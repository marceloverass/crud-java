
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


@WebServlet(name = "Editar", urlPatterns = {"/editar"})
public class Editar extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            UsuarioBean usuario = new UsuarioBean();
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nome = request.getParameter("nome");    
            String email = request.getParameter("email");    
            String senha = request.getParameter("senha");    
            try {

                   usuario.setCodigo(codigo);
                   usuario.setNome(nome);
                   usuario.setEmail(email);
                   usuario.setSenha(senha);
                   UsuarioDAO dao = new UsuarioDAO();
                   dao.alterar(usuario);
                   request.setAttribute("mensagem", "Dados atualizados com sucesso!!");
                   
                   RequestDispatcher rd = 
                    request.getRequestDispatcher("lista.jsp");
                    rd.forward(request, response);}
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
