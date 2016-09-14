/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import DTO.Produto;
import MODEL.ProdutoDao;
import Recursos.InOut;
import java.util.List;

/**
 * @author solaris
 */
public class Principal {
    public static void main(String[] args){
        ProdutoDao prodDAO = new ProdutoDao();
        Produto prod = new Produto("sdzffg", 15, "jkjkjkj");
         
       // if (prodDAO.Create(prod)){
      //      InOut.OutMessage(((Produto)prodDAO.Read(prod)).toString());
      //  }            
         
        List<Produto> lstProd = prodDAO.Select();
        String texto ="";
        for(int i = 0; i<lstProd.size(); i++){
            prod = lstProd.get(i);
            texto += prod.toString();
        }
        InOut.OutMessage(texto);
        
        prod = new Produto();
        
        prod.setIdProduto(InOut.InInt("Insira o ID do produto.: "));
        
        if(prodDAO.Delete(prod)){
            InOut.OutMessage(((Produto)prodDAO.Read(prod)).toString());
        }else{
            InOut.OutMessage("ERRO DELETAR");
        }
        
     
        
    }
}
