package br.com.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import br.com.entidade.UsuarioBean;
import java.io.PrintWriter;
import java.sql.Date;

public class UsuarioDAO  extends DAO{
     
    public void inserir(UsuarioBean usuario) throws Exception {
            try {

                abrirBanco();

                Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

                String query = "INSERT INTO usuario (codigo,nome,email,senha,data_criacao) values(null,?,?,?,?)";
                pst=(PreparedStatement) con.prepareStatement(query);
                pst.setString(1, usuario.getNome());
                pst.setString(2, usuario.getEmail());
                pst.setString(3, usuario.getSenha());
                pst.setString(4,  data.toString());
                pst.execute();
                fecharBanco();
            } catch (Exception e) {
                System.out.println("Erro " + e.getMessage());
            }
    }
    
    public ArrayList<UsuarioBean> pesquisarTudo () throws Exception {//criando o metodo do tipo vetor lista
         ArrayList<UsuarioBean> listUsuario = new ArrayList<UsuarioBean>();//criando o objeto lista ond serao adicionados os registros
         try{
            abrirBanco();  
            String query = "select * FROM usuario order by(codigo) limit 0,10";
            pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            UsuarioBean usuario ;
            while (rs.next()){ //lendo cada registro da tabela que será adicionando no vetor
              usuario = new UsuarioBean();
              usuario.setCodigo(rs.getInt("codigo"));//pegando o valor do campo codigo e gravando no objeto bean
              usuario.setNome(rs.getString("nome"));
              usuario.setEmail(rs.getString("email"));
              usuario.setDatacadastro(rs.getString("data_criacao"));

              listUsuario.add(usuario); //adicionando no vetor o registro que veio da tabela
            } 
            
            fecharBanco();
            
        }catch (Exception e){
           System.out.println("Erro " + e.getMessage());
        } 
        return listUsuario;//retornando a lista preenchida para a tela onde esta o html que mostrara para o usuaio a lista
    }
  
    public UsuarioBean pesquisar(int id) throws Exception {
    try {
            UsuarioBean usuario = new UsuarioBean();
            System.out.println(" Chegou no pesquisar registo" + id);
            abrirBanco();
            String query = "select * FROM usuario where codigo=?";
            pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                usuario.setCodigo(rs.getInt("codigo"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setDatacadastro(rs.getString("data_criacao"));

                return usuario;
            }
            fecharBanco();
    } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
    }
    return null;
	}
    
    public void deletar(UsuarioBean usuario) throws Exception{
         abrirBanco();
         String query = "delete from usuario where codigo=?";
         pst=(PreparedStatement) con.prepareStatement(query);
         pst.setInt(1, usuario.getCodigo());
         pst.execute();
        fecharBanco();
     }
     
    public void alterar(UsuarioBean usuario) throws Exception {
		try {
    abrirBanco();
    String query = "UPDATE usuario SET nome=?,email=?,senha=? WHERE codigo=?;";
    pst = con.prepareStatement(query);
    pst.setString(1, usuario.getNome());
    pst.setString(2, usuario.getEmail());
    pst.setString(3, usuario.getSenha());
    pst.setInt(4, usuario.getCodigo());

    pst.execute();
    fecharBanco();
			

    } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
    }
	}
}
