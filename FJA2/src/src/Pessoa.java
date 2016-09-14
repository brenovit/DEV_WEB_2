/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author alunoads
 */
public class Pessoa {
    private String nome = "";
    private String cpf = "";
    private static Pessoa instancia = null;    //Um objeto Pessoa que começou com nulo, objeto para transformar o construtor em sigleton
    
    
    private Pessoa() {
        
    }
    
    //Metodo para instancia a variavel instancia, caso ela já tenha sido criada
    public static Pessoa getInstancia(){        //Metodo do tipo Pessoa
        if(instancia == null){                  //caso a variavel instancia esteja null
            instancia = new Pessoa();           //Instancia o objeto
        }
        return instancia;                       //Retornando o objeto, se ele já foi criado ou não
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
