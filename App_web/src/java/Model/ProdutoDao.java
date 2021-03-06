
package Model;

import Dto.DtoProduto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ProdutoDao extends DaoUtil {

    public ProdutoDao() {
        super();
    }
    
    public boolean setAdicionar(DtoProduto produto) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO produto (nome, preco, validade, descricao)" + //query para adicionar 
                "VALUES (?,?,?,?)";
        int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql) //Contém agora toda a consulta da query
        ) {
            ps.setString(1,produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setDate(3, new java.sql.Date(produto.getValidade().getTime()));//definição de data
            ps.setString(4,produto.getDescricao());
            ret = ps.executeUpdate(); //"executeUpdate" metodo do preparedStatement
        }
         
         return ret > 0; // retornar se foi sucesso ou não a incesão de objeto 
    }
    
    
    public boolean setAlterar(DtoProduto produto) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE produto SET "+
                     "nome = ?, preco = ?, validade = ?, descricao = ? " + 
                     "WHERE idProduto = ?";
        
        int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql)) {
            ps.setString(1,produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setDate(3, new java.sql.Date(produto.getValidade().getTime()));//definição de data
            ps.setString(4,produto.getDescricao());
            ps.setInt (5, produto.getIdproduto());
            ret = ps.executeUpdate();
        }
         
         return ret > 0; // retorna se foi sucesso ou não a incersão de objeto 
    }
    
    
    public boolean setDeletar(DtoProduto produto) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM GerenciadorContas.dbo.produto "+
                     "WHERE idProduto = ?";
        
        int ret;
        try (PreparedStatement ps = super.getPreparedStatement(sql)) {
            ps.setInt (1, produto.getIdproduto());
            ret = ps.executeUpdate();
        }
         
         return ret > 0; // retanar se foi sucesso ou não a incesão de ob 
    }
    
    public List<DtoProduto> getRetornaTodos() throws ClassNotFoundException, SQLException{
        List<DtoProduto> lstRet = new LinkedList<DtoProduto>();
        String sql = "SELECT id, nome, preco, validade, descricao FROM GerenciadorContas.dbo.produto";        
        try (ResultSet rs = super.getStatement().executeQuery(sql)) {
            while(rs.next()){
                lstRet.add(new DtoProduto(rs.getInt("id"),
                        rs.getString ("nome"),
                        rs.getDouble("preco"),
                        rs.getDate("validade"),
                        rs.getString("descricao")));
            }
        }
        super.getFechaTudo();
        return lstRet;
    }
    
    public DtoProduto getPorId(DtoProduto produto) throws ClassNotFoundException, SQLException{
        DtoProduto lstRet = new DtoProduto();
        String sql = "SELECT id, nome, preco, validade, descricao FROM produto" + 
                      "WHERE id = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, produto.getIdproduto());
        try (ResultSet rs = ps.executeQuery()) {
            while(rs.next()){
                lstRet.setIdproduto(rs.getInt("id"));
                lstRet.setNome(rs.getString("nome"));
                lstRet.setPreco(rs.getDouble("preco"));
                lstRet.setValidade(rs.getDate("validade"));
                lstRet.setDescricao(rs.getString("descricao"));
            }
        }
        super.getFechaTudo();
        return lstRet;
    }

}
