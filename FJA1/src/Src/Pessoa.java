
package Src;

public class Pessoa {
    private String nome;
    private String cpf;
    private String rg;  
    private static Pessoa instancia = null;

    private Pessoa() {
        
    }
    
    public static Pessoa obtemPessoa(){
        if (instancia == null){
            instancia = new Pessoa();
        }
        return instancia;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    } 

    
      
    
}
