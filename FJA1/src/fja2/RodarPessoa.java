/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fja2;

import Src.Pessoa;

/**
 *
 * @author solaris
 */
public class RodarPessoa {
    public static void Executar(){
        Pessoa pessoa1 = Pessoa.obtemPessoa();
        
        pessoa1.setNome("Zé");
        pessoa1.setCpf("01493030507");
        pessoa1.setRg("Ssa1017259658");
        
        System.out.println("Pessoa: " + pessoa1.getNome() + 
                           ", CPF: " + pessoa1.getCpf() + 
                           ", RG: " +  pessoa1.getRg() );
        
        Pessoa pessoa2 = Pessoa.obtemPessoa();
        
        pessoa2.setNome("Maria");
        pessoa2.setCpf("12345678");
        pessoa2.setRg("Ssa1234578");
        
        System.out.println("Pessoa: " + pessoa1.getNome() + 
                           ", CPF: " + pessoa2.getCpf() + 
                           ", RG: " +  pessoa1.getRg());
        
        System.out.println(pessoa1);
        System.out.println(pessoa2);
    }
}
