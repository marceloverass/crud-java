
<%@page import="br.com.entidade.UsuarioBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.modelo.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resoucers/bootstrap/css/bootstrap.min.css">
        
        <style>
            th {text-align: center;}
        </style>
    </head>
    <body>
        <%@include file="menu.jsp" %> 
        <br/>

        <%
          String mensagem = (String) request.getAttribute("mensagem");
          
          
          if (mensagem == null){
              System.out.println("teste");
          }else {
        %>
        
        <div class="row">
            <div class="col-md-offset-2 col-md-4">
                <div class="alert alert-warning alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <%=mensagem%>
                </div>   
            </div>
        </div>
      
        <%} %>
          
        <div class="row">
            <div class="col-md-offset-2 col-md-8">
                <div class="table-responsive">
                    <table class="table table-striped  table-hover">
			<thead>
                            <tr>
				<th colspan="6" class="h2 text-center">Lista de Usuários</th>
                            </tr>
			</thead>
                        <br/>
                        
                        <tr>
                            <th>Código</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Data de Criação</th>
                            <th colspan="2">Ações</th>
                        </tr>
        <%
            String vcodigo="";
            String vnome="";
            String vemail="";
            String vDataCriacao="";
          
            UsuarioDAO dao = new UsuarioDAO(); 
            UsuarioBean usuario =  new UsuarioBean();
            
            ArrayList<UsuarioBean> listaUsuario = dao.pesquisarTudo();  //recebendo a lista gerada no DAO e colocando na lista que será
            //impressa na tela
            for (int i = 0; i < listaUsuario.size(); i++) {                
                usuario = listaUsuario.get(i);
                vcodigo= String.valueOf(usuario.getCodigo());
                vnome = String.valueOf(usuario.getNome());
                vemail = String.valueOf(usuario.getEmail());
                vDataCriacao = String.valueOf(usuario.getDatacadastro());
        %>
                        <tr>
                            <td class="text-center"><%=vcodigo%></td>
                            <td class="text-center"><%=vnome%></td> 
                            <td class="text-center"><%=vemail%></td> 
                            <td class="text-center"><%=vDataCriacao%></td> 
                            <td class="text-center">
                                <a href="alterar?codigo=<%=vcodigo%>" data-toggle="tooltip" title="Alterar">
                                    <span class="glyphicon-pencil text-primary"> </span> </a>
                                <a href="excluir?codigo=<%=vcodigo%>" onclick="return confirm('Confirma exclusão do registro <%=vnome%>?')" data-toggle="tooltip" title="Excluir">
                                    <span class="glyphicon glyphicon-trash text-danger"> </span> </a>
                            </td>
                        </tr>
                <%} //fechando FOR 
                %>
         
                    </table>
                </div>
            </div>
        </div>
                
        <script src="js/jquery-2.2.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
