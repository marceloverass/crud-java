<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>

        <link rel="stylesheet" href="resoucers/bootstrap/css/bootstrap.min.css">
    </head>
    <body>
        <%@include file="menu.jsp" %>

        <header>
            <h3 class="h2 text-center" >Cadastro de Usuário</h3><br/>
        </header>
        
        <%
          String mensagem = (String) request.getAttribute("mensagem");
          
          if (mensagem == null){
              //System.out.println("teste");
          }else {
        %>
        <div class="row">
            <div class="col-md-offset-4 col-md-4">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert"><span>&times;</span></button>
                    <%=mensagem%>
                </div>
            </div>
        </div>
      
        <%} %>
        <div class="col-md-offset-4 col-md-4">
            <div class="well well-lg"> 
         
                <form name="form" action="cadastrar" method="post" class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label" for="nome">Nome</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-user"></span> 
                            </div>   
                            <input type="text" name="nome" class="form-control" id="nome" placeholder="Digite um nome">  
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="email">Email</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-envelope"></span> 
                            </div>   
                            <input type="text" name="email" class="form-control" id="email" placeholder="fulano@gmail.com">  
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label" for="senha">Senha</label> <br>
                        <div class="input-group">
                            <div class="input-group-addon">
                                <span class="glyphicon glyphicon-lock"></span> 
                            </div>  
                            <input type="password" name="senha"  class="form-control" id="senha" placeholder="******">
                        </div>
                    </div>

                    <input type="submit" value="Enviar" class="btn btn-info">
                    <input type="reset" value="Limpar" class="btn btn-warning">
                </form>
             </div>
        </div>
  
        <script src="js/jquery-2.2.4.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>