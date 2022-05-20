
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


@WebServlet(name = "Alterar", urlPatterns = {"/alterar"})
public class Alterar extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int codigo = Integer.parseInt(request.getParameter("codigo"));
             UsuarioBean usuario = new UsuarioBean();

            try {
                   UsuarioDAO dao = new UsuarioDAO();
                   
                   usuario = dao.pesquisar(codigo);

                   RequestDispatcher rd = 
                    request.getRequestDispatcher("editar.jsp");
                    rd.forward(request, response);}
               catch(Exception e){

                       }
        	String msg = "";
                
		if (usuario == null) {

			msg = "Não foram encontrados registros.";

			request.setAttribute("msgResposta", msg);

			RequestDispatcher enviar = request
					.getRequestDispatcher("lista.jsp");
			enviar.forward(request, response);

		} else {
			request.setAttribute("usuarioBeanCodigo", usuario.getCodigo());
                        request.setAttribute("usuarioBeanNome", usuario.getNome());
			request.setAttribute("usuarioBeanEmail", usuario.getEmail());
                        request.setAttribute("usuarioBeanSenha", usuario.getSenha());
                        request.setAttribute("usuarioBeanDataCadastro", usuario.getDatacadastro());
                        RequestDispatcher lista = request
					.getRequestDispatcher("editar.jsp");
			lista.forward(request, response);
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
