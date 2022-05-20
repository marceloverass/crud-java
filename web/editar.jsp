
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Cadastro</title> 
        
        <link rel="stylesheet" href="resoucers/bootstrap/css/bootstrap.min.css">

    </head>
    <%  
        String vcodigo="";
        String vnome="";
        String vemail="";
        String vsenha="";
        String vdataCriacao;

         vcodigo = (String) request.getAttribute("usuarioBeanCodigo").toString();
         vnome    = (String) request.getAttribute("usuarioBeanNome").toString();
         vemail    = (String) request.getAttribute("usuarioBeanEmail").toString();
         vsenha    = (String) request.getAttribute("usuarioBeanSenha").toString();
         vdataCriacao = (String) request.getAttribute("usuarioBeanDataCadastro").toString();
 
    %>
    <body>
        <%@include file="menu.jsp" %> 
        
        <header>
            <h3 class="h3 text-center" >Alterar este usuário?</h3><br/>
        </header>
        
        <div class="col-md-offset-4 col-md-4">
            <div class="well well-lg"> 
        
                <form name="form" action="editar" method="post">
                     Código do Usuário: <span class="badge"> <%=vcodigo%></span>
                    <input type="hidden" name="codigo" value="<%=vcodigo%>">
                    <br/>
                    
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span> 
                            </div>   
                            <input type="text" name="nome" value="<%=vnome%>" class="form-control" id="nome">  
                        </div>
                    </div>
                  
                    <div class="form-group">
                        <label class="control-label" for="email">Email</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-envelope"></span> 
                            </div>   
                            <input type="text" name="email" value="<%=vemail%>" class="form-control" id="email">  
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label" for="senha">Senha</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="password" name="senha" value="<%=vsenha%>" class="form-control" id="senha">
                        </div>
                    </div>
                        
                    <div class="form-group">
                        <label class="control-label">Data de Criação</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-calendar"></span> 
                            </div>  
                            <input type="text" value="<%=vdataCriacao%>" class="form-control" readonly="">
                        </div>
                    </div> 

                      
                    <input type="submit" value="Alterar" class="btn btn-info">
                </form>
            </div>
        </div>
        
        <script src="js/jquery-2.2.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>
