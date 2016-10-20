package MODEL;

import DTO.DtoProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO extends DaoUtil {

    public ProdutoDAO() {
        super();
    }

    public boolean setAdicionar(DtoProduto produto) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO tbProduto "
                + "(nome, preco, validade, descricao) "
                + "VALUES (?, ?, ?, ?)";

        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setDouble(2, produto.getPreco());
        ps.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
        ps.setString(4, produto.getDescricao());

        int ret = ps.executeUpdate();
        ps.close();

        return ret > 0;
    }

    public boolean setAlterar(DtoProduto produto) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE tbProduto SET "
                + "nome = ?, preco = ?, validade = ?, descricao = ? "
                + "WHERE idProduto = ?";

        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setDouble(2, produto.getPreco());
        ps.setDate(3, new java.sql.Date(produto.getValidade().getTime()));
        ps.setString(4, produto.getDescricao());
        ps.setInt(5, produto.getIdproduto());

        int ret = ps.executeUpdate();
        ps.close();

        return ret > 0;
    }

    public boolean setDeletar(DtoProduto produto) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM tbProduto "
                + "WHERE idProduto = ?";

        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, produto.getIdproduto());
        int ret = ps.executeUpdate();
        ps.close();

        return ret > 0;
    }

    public List<DtoProduto> getRetornaTodos() throws ClassNotFoundException, SQLException {
        List<DtoProduto> lstRet = new LinkedList<DtoProduto>();
        String sql = "SELECT idProduto, nome, preco, "
                + "validade, descricao FROM tbProduto";

        ResultSet rs = super.getStatement().executeQuery(sql);
        while (rs.next()) {
            lstRet.add(new DtoProduto(rs.getInt("idProduto"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getDate("validade"),
                    rs.getString("descricao")));
        }
        rs.close();
        super.getFechaTudo();
        return lstRet;
    }

    public DtoProduto getPorId(DtoProduto produto) throws ClassNotFoundException, SQLException {
        DtoProduto lstRet = new DtoProduto();
        String sql = "SELECT idProduto, nome, preco, "
                + "validade, descricao FROM tbProduto "
                + "WHERE idProduto = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, produto.getIdproduto());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            lstRet.setIdproduto(rs.getInt("idProduto"));
            lstRet.setNome(rs.getString("nome"));
            lstRet.setPreco(rs.getDouble("preco"));
            lstRet.setValidade(rs.getDate("validade"));
            lstRet.setDescricao(rs.getString("descricao"));
        }
        rs.close();
        super.getFechaTudo();
        return lstRet;
    }
}
