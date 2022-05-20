package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastrar</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"resoucers/bootstrap/css/bootstrap.min.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <h3 class=\"h3 text-center\" >Cadastro de Usuário</h3>\n");
      out.write("        </header>\n");
      out.write("        \n");
      out.write("        <div class=\"col-md-offset-4 col-md-4\">\n");
      out.write("            <div class=\"well well-lg\"> \n");
      out.write("         \n");
      out.write("                <form name=\"form\" action=\"cadastrar\" method=\"post\" class=\"form-horizontal\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"control-label\">Nome:</label><br>\n");
      out.write("\n");
      out.write("                            <div class=\"input-group\">\n");
      out.write("                                <div class=\"input-group-addon\">\n");
      out.write("                                    <span class=\"glyphicon glyphicon-user\"></span> \n");
      out.write("                                </div>\n");
      out.write("                                \n");
      out.write("                               <input type=\"text\" name=\"nome\" class=\"form-control\" placeholder=\"Digite um nome\">  \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    \n");
      out.write("                    <br>\n");
      out.write("                    <label>E-mail:</label><br>\n");
      out.write("                    <input type=\"text\" name=\"email\"  class=\"form-control\" placeholder=\"fulano@gmail.com\">\n");
      out.write("                    <br>\n");
      out.write("                    <label>Senha:</label><br>\n");
      out.write("                    <input type=\"password\" name=\"senha\"  class=\"form-control\" placeholder=\"******\">\n");
      out.write("                    <br><br>   \n");
      out.write("                    \n");
      out.write("                    <input type=\"submit\" value=\"Enviar\" class=\"btn btn-primary\">\n");
      out.write("                    <input type=\"reset\" value=\"Limpar\" class=\"btn btn-warning\">\n");
      out.write("                </form>\n");
      out.write("             </div>\n");
      out.write("        </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-2.2.4.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
