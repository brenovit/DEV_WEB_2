/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author alunoads
 */
public class DtoProduto implements Serializable{
    private int idproduto;
    private String nome;
    private double preco;
    private Date validade;
    private String descricao;

    public DtoProduto() {
    }

    public DtoProduto(int idproduto, String nome, double preco, Date validade, String descrição) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.preco = preco;
        this.validade = validade;
        this.descricao = descrição;
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
