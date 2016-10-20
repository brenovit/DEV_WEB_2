package CONTROLLER;

import DTO.DtoProduto;
import MODEL.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class ProdutoFaces {
    private ProdutoDAO proDao = new ProdutoDAO();
    private DtoProduto produtoselecionado;
    List<DtoProduto> produtos = null;
    
    public ProdutoFaces() {
    }

    public DtoProduto getProdutoselecionado() {
        return produtoselecionado;
    }

    public void setProdutoselecionado(DtoProduto produtoselecionado) {
        this.produtoselecionado = produtoselecionado;
    }

    public List<DtoProduto> getProdutos() throws ClassNotFoundException, SQLException {
        if(this.produtos == null){
            produtos = proDao.getRetornaTodos();
        }
        return produtos;
    }
    
    public String preparaInclusao(){
        this.produtoselecionado = new DtoProduto();
        return "VaiParaIncluir";
    }
    
    public String finalizaInclusao() throws ClassNotFoundException, SQLException{
        proDao.setAdicionar(produtoselecionado);
        this.produtos = null;
        return "VoltarListagem";
    }
    
    public String finalizaAlteracao() throws ClassNotFoundException, SQLException{
        proDao.setAlterar(produtoselecionado);
        this.produtos = null;
        return "VoltarListagem";
    }
    
    public String finalizaDelecaoo() throws ClassNotFoundException, SQLException{
        proDao.setDeletar(produtoselecionado);
        this.produtos = null;
        return "refresh";
    }
}
