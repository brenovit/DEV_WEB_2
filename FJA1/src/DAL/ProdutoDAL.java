/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Model.Produto;
import Recursos.InOut;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author solaris
 */
public class ProdutoDAL implements IBanco{
    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rst = null;
    
    @Override
    public void Create(Object o) {
        //TODO Inserir um dado no banco
        try{
            conn = Banco.Connect();
            conn.setAutoCommit(false);  //define que ele não vai trabalhar diretamente no banco
            
            String query = "INSERT INTO tbProduto (nome, preco, validade, descricao) VALUES (?, ?, ?, ?)";
            pst = conn.prepareStatement(query);
            
            pst.setString(1, ((Produto)o).getNome());
            pst.setFloat(2, ((Produto)o).getPreco());            
            pst.setDate(3, new java.sql.Date(new Date().getTime()));
            pst.setString(4, ((Produto)o).getDescricao());
                        
            int qtd = pst.executeUpdate();
            
            //conn.rollback();
            conn.commit();      //finaliza a query e joga os dados no banco
            
            conn.close();
            pst.close();        
            
            
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "ERRO", 1);
        }finally{
            Banco.Disconnect();
        }
    }

    @Override
    public void Read(Object o) {
        //TODO Buscar um dado no banco
        try{
            
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "ERRO", 1);
        }
    }

    @Override
    public void Update(Object o) {
        //TODO Atualizar um dado no banco
        try{
            
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "ERRO", 1);
        }
    }

    @Override
    public void Delete(Object o) {
        //TODO Deletar um dado no banco
        try{
            
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "ERRO", 1);
        }
    }

    @Override
    public ResultSet Select() {
        //TODO Inserir dado no banco
        try{
            conn = Banco.Connect();
            //conn.setAutoCommit(false);
            
            String query = "SELECT nome, descricao, preco FROM tbProduto";
            pst = conn.prepareStatement(query);
                                    
            rst = pst.executeQuery(query);

            conn.close();
            pst.close();        
            
            //conn.rollback();
            return null;
        }catch(Exception e){
            InOut.OutMessage("ERRO: "+e.getMessage(), "ERRO", 1);
        }
         return null;
    }
    
}
