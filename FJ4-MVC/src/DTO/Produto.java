package DTO;

import java.util.Date;

/**
 *
 * @author Breno
 */
public class Produto {
    private int idProduto;
    private String nome;
    private Date validade;
    private double preco;
    private String descricao;
   
    public Produto(){        
    }
    
 public Produto(int idProduto, String nome, Date validade, double preco, String descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.validade = validade;
        this.preco = preco;
        this.descricao = descricao;
    }
    
    public Produto(String nome, double preco, String descricao) {        
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }        

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * @return the preco
     */
    public double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String toString(){
        return "\nID:"+this.idProduto+"\nNome: "+this.nome + "\nPreço: R$"+this.preco+"\nValidade: "+this.validade+"\nDescrição: "+this.descricao+"\n====================";
    }
}
