package DTO;

import java.util.Date;


public class DtoProduto {
    private int idproduto;
    private String nome;
    private double preco;
    private Date validade;
    private String descricao;

    public DtoProduto() {
    }

    public DtoProduto(int idproduto, String nome, double preco, Date validade, String descricao) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.descricao = descricao;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
