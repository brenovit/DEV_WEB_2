
package fja_excecao;

public class Zero {
    
    
    public static double calc(int a, int b){
        try{
            return a / b;
        }catch(Exception e){
            System.out.println("Erro.: " + e.getMessage());
            return 0;
        }finally{
             System.out.println("Eu sou um Finally!");
        }
    }
}
