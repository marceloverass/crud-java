
package br.com.controle;

import br.com.entidade.UsuarioBean;
import br.com.modelo.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Excluir", urlPatterns = {"/excluir"})
public class Excluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
          String nome= request.getParameter("nome");
          String codigo= request.getParameter("codigo");
            UsuarioBean  usuario = new UsuarioBean();// criando o objeto usuario
             usuario.setCodigo(Integer.valueOf(codigo));
              // o sistema utilizará a data atual
                   UsuarioDAO dao = new UsuarioDAO();
              try {
               
                dao.deletar(usuario);
                request.setAttribute("mensagem", "Usuário excluído com sucesso!!");

                RequestDispatcher rd = 
                request.getRequestDispatcher("lista.jsp");
                rd.forward(request, response);
               }
               catch(Exception e){
               
               }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
