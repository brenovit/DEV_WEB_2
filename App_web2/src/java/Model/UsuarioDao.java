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
       String sql = "INSERT INTO usuario (Nome, Login, Senha, email, tipo_usuario) values (?,?,?,?,1)";
       int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql)) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getSenha());
            ps.setString(4, user.getEmail());
            ret = ps.executeUpdate();
        }
       return ret > 0;
   }
   
   public boolean setAlterar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE usuario SET "+
                     "Nome = ?, Login = ?, Senha = ? " + 
                     "WHERE id = ?";
        
        int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql)) {
            ps.setString(1,user.getNome());
            ps.setString(2, user.getLogin());
            ps.setString(3,user.getSenha());
            ps.setInt (4, user.getId());
            ret = ps.executeUpdate();
        }
         
         return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
    }
    
    public boolean setDeletar(DtoUsuario user) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM usuario "+
                     "WHERE id = ?";
        
        int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql)) {
            ps.setInt (1, user.getId());
            ret = ps.executeUpdate();
        }
         
         return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }
    
    public List<DtoUsuario> getRetornaTodos() throws ClassNotFoundException, SQLException{
        List<DtoUsuario> lstRet = new LinkedList<DtoUsuario>();
        String sql = "SELECT id, nome, login, senha FROM GerenciadorContas.dbo.usuario";
        
        try (ResultSet rs = super.getStatement().executeQuery(sql)) {
            while(rs.next()){
                lstRet.add(new DtoUsuario(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("login"),
                        rs.getString("Senha")));
            }
        }
        super.getFechaTudo();
        return lstRet;
    }
    
    public DtoUsuario getPorId(DtoUsuario user) throws ClassNotFoundException, SQLException{
        DtoUsuario dtoUser = new DtoUsuario();
        String sql = "SELECT id, Nome, Login, Senha FROM usuario" + 
                      "WHERE id = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, user.getId());
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                dtoUser.setId(rs.getInt("id"));
                dtoUser.setNome(rs.getString("Nome"));
                dtoUser.setLogin(rs.getString("Login"));
                dtoUser.setSenha(rs.getString("Senha"));
            }
        }
        super.getFechaTudo();
        return dtoUser;
    }

    
}
