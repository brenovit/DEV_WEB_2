package MODEL;

import DTO.DtoProduto;
import DTO.DtoUsuario;
import DTO.DtoVenda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class VendaDAO extends DaoUtil{

    public VendaDAO() {
        super();
    }
    
    public boolean setAdicionar(DtoVenda venda) throws ClassNotFoundException, SQLException{
        String sql = "INSERT INTO tbVenda (idUsuario, idProduto, vlVenda) VALUES (?,?,?)";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getUsuario().getIdusuario());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setDouble(3, venda.getVlvenda());
        int ret = ps.executeUpdate();
        ps.close();
        super.close();
        return ret > 0;
    }
    
    public boolean setAlterar(DtoVenda venda) throws ClassNotFoundException, SQLException{
        String sql = "UPDATE tbVenda "
                + "idUsuario = ?, idProduto = ?, vlVenda = ? WHERE idVenda = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getUsuario().getIdusuario());
        ps.setInt(2, venda.getProduto().getIdproduto());
        ps.setDouble(3, venda.getVlvenda());
        ps.setInt(4, venda.getIdVenda());
        int ret = ps.executeUpdate();
        ps.close();
        super.close();
        return ret > 0;
    }
    
    public boolean setDeletar(DtoVenda venda) throws ClassNotFoundException, SQLException{
        String sql = "DELETE FROM tbVenda WHERE idVenda = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getIdVenda());
        int ret = ps.executeUpdate();
        ps.close();
        super.close();
        return ret > 0;
    }
    
    public List<DtoVenda> getRetornaTodos() throws ClassNotFoundException, SQLException{
        List<DtoVenda> lstVenda = new LinkedList<DtoVenda>();
        String sql = "SELECT idVenda, idProduto, idUsuario, vlVenda FROM tbVenda ";

        ResultSet rs = super.getStatement().executeQuery(sql);
        ProdutoDAO prodDAO = new ProdutoDAO();
        UsuarioDAO usuDAO = new UsuarioDAO();
        while(rs.next()){
            DtoVenda vendaAux = new DtoVenda();
            vendaAux.setIdvenda(rs.getInt("idVenda"));
            vendaAux.setVlvenda(rs.getDouble("vlVenda"));
            
            DtoProduto prodAux = new DtoProduto();
            prodAux.setIdproduto(rs.getInt("idProduto"));
            vendaAux.setProduto(prodDAO.getPorId(prodAux));
            
            DtoUsuario usuAux = new DtoUsuario();
            usuAux.setIdusuario(rs.getInt("idUsuario"));
            vendaAux.setUsuario(usuDAO.getPorId(usuAux));
            lstVenda.add(vendaAux);
        }
        rs.close();
        super.close();
        return lstVenda;
    }
    
    public List<DtoVenda> getPorVendedor(DtoVenda venda) throws ClassNotFoundException, SQLException {
        List<DtoVenda> lstVenda = new LinkedList<DtoVenda>();
        String sql = "SELECT idVenda, idProduto, idUsuario, vlVenda FROM tbVenda WHERE idUsuario = ?";
        PreparedStatement ps = super.getPreparedStatement(sql);
        ps.setInt(1, venda.getUsuario().getIdusuario());
        ResultSet rs = ps.executeQuery();
        ProdutoDAO prodDAO = new ProdutoDAO();
        UsuarioDAO usuDAO = new UsuarioDAO();
        while(rs.next()){
            DtoVenda vendaAux = new DtoVenda();
            vendaAux.setIdvenda(rs.getInt("idVenda"));
            vendaAux.setVlvenda(rs.getDouble("vlVenda"));
            
            DtoProduto prodAux = new DtoProduto();
            prodAux.setIdproduto(rs.getInt("idProduto"));
            vendaAux.setProduto(prodDAO.getPorId(prodAux));
            
            DtoUsuario usuAux = new DtoUsuario();
            usuAux.setIdusuario(rs.getInt("idUsuario"));
            vendaAux.setUsuario(usuDAO.getPorId(usuAux));
            lstVenda.add(vendaAux);
        }
        rs.close();
        super.close();
        return lstVenda;
    }
    
}
