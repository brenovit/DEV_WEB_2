
package Model;

import Dto.DtoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UsuarioDao extends DaoUtil{

    public UsuarioDao() {
        super();
    }
    
   public boolean setAdicionar(DtoUsuario user) throws ClassNotFoundException, SQLException{ 
       String sql = "INSERT INTO tbUsuario (Nome, Login, Senha) values (?,?,?)";
       PreparedStatement ps = super.getPreparedStatement(sql);
       ps.setString(1, user.getNome());
       ps.setString(2, user.getLogin());
       ps.setString(3, user.getSenha());
       
       int ret = ps.executeUpdate();
       ps.close();
       return ret > 0;
   }
   
   public boolean setAlterar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE tbUsuario SET "+
                     "Nome = ?, Login = ?, Senha = ? " + 
                     "WHERE idUsuario = ?";
        
         PreparedStatement ps = super.getPreparedStatement(sql);
         ps.setString(1,user.getNome());
         ps.setString(2, user.getLogin());
         ps.setString(3,user.getSenha());
         ps.setInt (4, user.getId());
        
         int ret = ps.executeUpdate();
         ps.close();
         
         return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
    }
    
    
    public boolean setDeletar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM tbUsuario "+
                     "WHERE idUsuario = ?";
        
         PreparedStatement ps = super.getPreparedStatement(sql);
         ps.setInt (1, user.getId());
         int ret = ps.executeUpdate();
         ps.close();
         
         return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }
    
    public List<DtoUsuario> getRetornaTodos() throws ClassNotFoundException, SQLException{
        List<DtoUsuario> lstRet = new LinkedList<DtoUsuario>();
        String sql = "SELECT idUsuario, Nome, Login, Senha FROM tbUsuario";
        
        ResultSet rs = super.getStatement().executeQuery(sql);
        while(rs.next()){
            lstRet.add(new DtoUsuario(rs.getInt("idUsuario"),
                                      rs.getString("Nome"),
                                      rs.getString("Login"),
                                      rs.getString("Senha")));
        }
        rs.close();
        super.getFechaTudo();
        return lstRet;
    }
    
    public DtoUsuario getPorId(DtoUsuario user) throws ClassNotFoundException, SQLException{
        DtoUsuario dtoUser = new DtoUsuario();
        String sql = "SELECT idUsuario, Nome, Login, Senha FROM tbUsuario" + 
                      "WHERE idUsuario = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, user.getId());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            dtoUser.setId(rs.getInt("idUsuario"));
            dtoUser.setNome(rs.getString("Nome"));
            dtoUser.setLogin(rs.getString("Login"));  
            dtoUser.setSenha(rs.getString("Senha"));
        }
        rs.close();
        super.getFechaTudo();
        return dtoUser;
    }

    
}
