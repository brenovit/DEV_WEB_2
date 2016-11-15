package CONTROLLER;

import DTO.DtoProduto;
import MODEL.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;

public class ProdutoFaces {
    private final ProdutoDAO proDao = new ProdutoDAO();
    private DtoProduto produto;
    private List<DtoProduto> listaProdutos = null;
    
    public ProdutoFaces() {
    }

    public DtoProduto getProduto() {
        return produto;
    }

    public void setProduto(DtoProduto produto) {
        this.produto = produto;
    }

    public List<DtoProduto> getListaProdutos() throws ClassNotFoundException, SQLException {
        if(this.listaProdutos == null){
            listaProdutos = proDao.getRetornaTodos();
        }
        return listaProdutos;
    }
    
    public String preparaInclusao(){
        this.produto = new DtoProduto();
        return "VaiParaIncluir";
    }
    
    public String finalizaInclusao() throws ClassNotFoundException, SQLException{
        proDao.setAdicionar(produto);
        this.produto = null;
        this.listaProdutos = null;
        return "VoltarListagem";
    }
    
    public String finalizaAlteracao() throws ClassNotFoundException, SQLException{
        proDao.setAlterar(produto);
        this.listaProdutos = null;
        return "VoltarListagem";
    }
    
    public String finalizaDelecaoo() throws ClassNotFoundException, SQLException{
        proDao.setDeletar(produto);
        this.listaProdutos = null;
        return "Atualizar";
    }
    
    public String listagemProduto(){
        return "ListagemProduto";
    }
    
    public String voltarPrincipal(){
        return "VoltarPrincipal";
    }
}
