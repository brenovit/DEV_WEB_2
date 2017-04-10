package Model;

import Dto.DtoProduto;
import Dto.DtoUsuario;
import Dto.DtoVenda;
import Dto.DtoVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VendaDao extends DaoUtil {

    public VendaDao() {
        super();
    }

    public boolean setAdicionar(DtoVenda venda) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbVenda (idUsuario,idProduto, vlVenda) VALUES(?,?,?)";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getUsuario().getId());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setDouble(3, venda.getVlVenda());

        int ret = ps.executeUpdate();
        ps.close();
        return ret > 0;
    }

    public boolean setAlterar(DtoVenda venda) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbVenda SET "
                + "idUsuario = ?, idProduto = ?, vlVenda = ? "
                + "WHERE idVenda = ?";

        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getUsuario().getId());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setDouble(3, venda.getVlVenda());
        ps.setInt(4, venda.getIdVenda());

        int ret = ps.executeUpdate();
        ps.close();

        return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
    }

    public boolean setDeletar(DtoVenda venda) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM tbVenda "
                + "WHERE idVenda = ?";

        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getIdVenda());
        int ret = ps.executeUpdate();
        ps.close();

        return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }

    public List<DtoVenda> getRetornaTodos() throws ClassNotFoundException, SQLException {
        List<DtoVenda> lstVenda = new LinkedList<DtoVenda>();
        String sql = "SELECT idVenda, idUsuario, idProduto, vlVenda FROM tbVenda";

        ResultSet rs = super.getStatement().executeQuery(sql);
        while (rs.next()) {
            DtoVenda venda = new DtoVenda();

            ProdutoDao prodDao = new ProdutoDao();
            DtoProduto prodDto = new DtoProduto();
            prodDto.setIdproduto(rs.getInt("idProduto"));
            
            UsuarioDao userDao = new UsuarioDao();
            DtoUsuario userDto = new DtoUsuario();
            userDto.setId(rs.getInt("idUsuario"));

            venda.setIdVenda(rs.getInt("idVenda"));
            venda.setProduto(prodDao.getPorId(prodDto));
            venda.setUsuario(userDao.getPorId(userDto));
            venda.setVlVenda(rs.getDouble("vlVenda"));
            lstVenda.add(venda);
        }
        rs.close();
        super.getFechaTudo();
        return lstVenda;
    }

    /*public DtoVenda getPorId(DtoVenda venda) throws ClassNotFoundException, SQLException {
        DtoVenda dtoVenda = new DtoVenda();

        String sql = "SELECT idUsuario, Nome, Login, Senha FROM tbUsuario"
                + "WHERE idUsuario = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getIdVenda());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            venda.setIdVenda(rs.getInt("idUsuario"));
            venda.setNome(rs.getString("Nome"));
            venda.setLogin(rs.getString("Login"));
            venda.setSenha(rs.getString("Senha"));
        }
        rs.close();
        super.getFechaTudo();
        return venda;
    }*/
}
