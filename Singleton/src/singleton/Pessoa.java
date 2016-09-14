/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

/**
 *
 * @author alunoads
 */
public class Pessoa {

    private String cpf;
    private String nome;
    private String rg;

    private static Pessoa instancia = null; //singletong

    private Pessoa() {

    }

    public static Pessoa otemPessoa() {
        if (instancia == null) {
            instancia = new Pessoa();
        }
        return instancia;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String toString() {
        return "Nome: " + this.nome + "\nRg: " + this.rg + "\nCPF: " + this.cpf;
    }
}
