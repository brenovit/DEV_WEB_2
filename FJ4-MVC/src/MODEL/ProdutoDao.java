package MODEL;

import DTO.Produto;
import Recursos.InOut;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Breno
 */
public class ProdutoDao extends DaoUtil implements IBanco{

    public ProdutoDao() {
        super();
    }    
    
    @Override
    public boolean Create(Object o) {
        //TODO Inserir um dado no banco
        try{
            //super.getConnection().setAutoCommit(false); //define que ele não vai trabalhar diretamente no banco
            
            String query = "INSERT INTO tbProduto (nome, preco, validade, descricao) VALUES (?, ?, ?, ?)";
            
            PreparedStatement pst = super.getPreparedStatement(query);
            
            pst.setString(1, ((Produto)o).getNome());
            pst.setDouble(2, ((Produto)o).getPreco());            
            pst.setDate(3, new java.sql.Date(new Date().getTime()));
            pst.setString(4, ((Produto)o).getDescricao());
                        
            int qtd = pst.executeUpdate();
            
            //conn.rollback();
            //super.getConnection().commit();      //finaliza a query e joga os dados no banco
            pst.close();   
            super.Disconnect();  
            return qtd > 0;
            
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "CREATE", 1);
            return false;
        }
    }

    @Override
    public boolean Update(Object o) {
        //TODO Atualizar um dado no banco
        try{
            // super.getConnection().setAutoCommit(false); //define que ele não vai trabalhar diretamente no banco
            
            String query = "UPDATE FROM tbProduto SET nome = ?, preco = ?, validade = ?, descricao = ? WHERE idProduto = ?";
            
            PreparedStatement pst = super.getPreparedStatement(query);
            
            pst.setString(1, ((Produto)o).getNome());
            pst.setDouble(2, ((Produto)o).getPreco());            
            pst.setDate(3, new java.sql.Date(new Date().getTime()));
            pst.setString(4, ((Produto)o).getDescricao());
            pst.setInt(5, ((Produto)o).getIdProduto());
            int qtd = pst.executeUpdate();
            
            //conn.rollback();
            //super.getConnection().commit();      //finaliza a query e joga os dados no banco
            pst.close();   
            super.Disconnect(); 
            return qtd > 0;
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "UPDATE", 1);
            return false;
        }
    }

    @Override
    public boolean Delete(Object o) {
        //TODO Deletar um dado no banco
        try{
            // super.getConnection().setAutoCommit(false); //define que ele não vai trabalhar diretamente no banco
            
            String query = "DELETE FROM tbProduto WHERE idProduto = ?";
            
            PreparedStatement pst = super.getPreparedStatement(query);
            
            pst.setInt(1, ((Produto)o).getIdProduto());           
                        
            int qtd = pst.executeUpdate();
            
            //conn.rollback();
            //super.getConnection().commit();      //finaliza a query e joga os dados no banco
            pst.close();   
            super.Disconnect();    
            return qtd > 0;
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "DELETE", 1);
            return false;
        }
    }
    
    @Override
    public Produto Read(Object o) {
        //TODO Inserir dado no banco
        try{
            //super.getConnection().setAutoCommit(false); //define que ele não vai trabalhar diretamente no banco
            List<Produto> lstProduto = new LinkedList<Produto>();
            String query = "SELECT idProduto, nome, descricao, preco, validade FROM tbProduto WHERE nome like ?";
           
            PreparedStatement pst = super.getPreparedStatement(query);
            if(((Produto)o).getNome().equals(null)){
                 super.Disconnect();
                 return null;
            }
            pst.setString(1, ((Produto)o).getNome());
            
            ResultSet rs = pst.executeQuery();
            
            Produto pro = null;
            
            if(rs.next()){
               pro = new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getDate("descricao"), rs.getDouble("preco"), rs.getString("descricao"));
            }
                        
            rs.close();
            
            //super.getConnection().commit();      //finaliza a query e joga os dados no banco
            super.Disconnect();    
            return pro;    
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "READ", 1);
        }
         return null;
    }
    
    @Override
    public List<Produto> Select() {
        //TODO Inserir dado no banco
        try{
            //super.getConnection().setAutoCommit(false); //define que ele não vai trabalhar diretamente no banco
            List<Produto> lstProduto = new LinkedList<Produto>();
            String query = "SELECT idProduto, nome, descricao, preco, validade FROM tbProduto";
            
            ResultSet rs = super.getStatement().executeQuery(query);
            
            while(rs.next()){
                lstProduto.add(new Produto(rs.getInt("idProduto"), rs.getString("nome"), rs.getDate("descricao"), rs.getDouble("preco"), rs.getString("descricao")));
            }
                        
            rs.close();
            
            //super.getConnection().commit();      //finaliza a query e joga os dados no banco
            super.Disconnect();    
            return lstProduto;    
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "SELECT", 1);
        }
         return null;
    }
    
}
