
package br.com.controle;

import br.com.entidade.UsuarioBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.modelo.UsuarioDAO;

@WebServlet(name = "Cadastro", urlPatterns = {"/cadastrar"})
public class Cadastro extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nome = request.getParameter("nome");    
            String email = request.getParameter("email");    
            String senha = request.getParameter("senha"); 
            
            if(nome.isEmpty() || email.isEmpty() || senha.isEmpty()){
                request.setAttribute("mensagem", "Todos os campos são obrigatórios!!");

                RequestDispatcher rd = 
                request.getRequestDispatcher("cadastro.jsp");
                rd.forward(request, response);
            }
            try {
                UsuarioBean usuario = new UsuarioBean();

                usuario.setNome(nome);
                usuario.setEmail(email);
                usuario.setSenha(senha);
                   
                UsuarioDAO dao = new UsuarioDAO();
                   
                dao.inserir(usuario);

                request.setAttribute("mensagem", "Usuário cadastrado com Sucesso!!");

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
