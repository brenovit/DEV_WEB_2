
package Controller;

import Dto.DtoProduto;
import Model.ProdutoDao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;


//@Named(value = "ProdutoFaces")
public class ProdutoFaces implements Serializable{
    
    private List<DtoProduto> listaProdutos = null;
    private ProdutoDao produtoDao = new ProdutoDao();
    private DtoProduto dto;
    
    public ProdutoFaces() {        
    }

    public ProdutoDao getProdutoDao() {
        return produtoDao;
    }

    public void setProdutoDao(ProdutoDao produtoDao) {
        this.produtoDao = produtoDao;
    }

    public List<DtoProduto> getLista() throws ClassNotFoundException, SQLException {
        if(listaProdutos == null){
            listaProdutos = produtoDao.getRetornaTodos();
        }
        return listaProdutos;
    }
    
    public DtoProduto getDto() {
        return dto;
    }

    public void setDto(DtoProduto dto) {
        this.dto = dto;
    }
    
    public String preparaInclusao(){
        this.dto = new DtoProduto();
        return "Incluir";
    }
    
    public String finalizaInclusao() throws ClassNotFoundException, SQLException{
        produtoDao.setAdicionar(dto);
        this.listaProdutos = null;
        return "VoltarListagem";
    }
    
    public String finalizaAlteracao() throws ClassNotFoundException, SQLException{
       String msg;
        if(produtoDao.setAlterar(this.getDto())){
            System.out.println("Usuario alterado com sucesso");
            this.listaProdutos = null;          //Limpando o cache, para ver se já ta criado ou não o objeto
        }
        return "Alterar";
    }
    
    public String deletar() throws ClassNotFoundException, SQLException{
        produtoDao.setDeletar(dto);
        this.listaProdutos = null;
        return "Excluir";
    }        
}
