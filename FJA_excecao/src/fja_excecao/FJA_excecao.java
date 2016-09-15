/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fja_excecao;

/**
 *
 * @author alunoads
 */
public class FJA_excecao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       /* System.out.println(Zero.calc(5, 0));
        System.out.println(Zero.calc(5, 5));
        System.out.println(Zero.calc(6, 2));*/
        
        Divisao d = new Divisao(2, 0);
        d.divide();

    }
    
}
