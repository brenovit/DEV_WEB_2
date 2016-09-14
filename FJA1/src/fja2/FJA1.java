
package fja2;

import DAL.Banco;


public class FJA1 {

    public static void main(String[] args) {
              Banco banco = new Banco();
              banco.Insert("Chocolate", 6.99F, "Muito doce");
              banco.Select();
         
    }    
}
