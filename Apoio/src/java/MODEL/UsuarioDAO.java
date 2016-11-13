package MODEL;

import DTO.DtoUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class UsuarioDAO extends DaoUtil{

    public UsuarioDAO() {
        super();
    }
    
    public List<DtoUsuario> getRetornaTodos() throws ClassNotFoundException, SQLException {
        List<DtoUsuario> lstRet = new LinkedList<DtoUsuario>();
        String sql = "SELECT idUsuario, nome, Login, Senha FROM tbUsuario";

        ResultSet rs = super.getStatement().executeQuery(sql);
        while (rs.next()) {
            lstRet.add(new DtoUsuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nome"),
                    rs.getString("Login"),
                    rs.getString("Senha"))
            );
        }
        rs.close();
        super.close();
        return lstRet;
    }

    public DtoUsuario getPorId(DtoUsuario usuario) throws ClassNotFoundException, SQLException {
        DtoUsuario lstRet = new DtoUsuario();
        String sql = "SELECT idUsuario, nome, Login, Senha FROM tbUsuario WHERE idUsuario = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, usuario.getIdusuario());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lstRet.setIdusuario(rs.getInt("idUsuario"));
            lstRet.setNome(rs.getString("nome"));
            lstRet.setLogin(rs.getString("Login"));
            lstRet.setSenha(rs.getString("Senha"));
        }
        rs.close();
        super.close();
        return lstRet;
    }
}
