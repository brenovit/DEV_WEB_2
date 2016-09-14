package Source;

/**
 * @author solaris
 */
public class FJ3 {
   public static  void main (String[] args) {
       Operacao operacao = new Multiplicacao();  //coerção, propriedade da herança
       int modo = 3;
                            
       if(modo == 0){
           operacao = new Soma();
       } else if(modo == 1){
           operacao = new Multiplicacao();
       }else if(modo == 2){
           operacao = new Divisao();
       } else{
           operacao = new Subtracao();
       }      
       
       int result = operacao.handleOperacao(4,5);
       System.out.println("Resultado: "+result);
               
   }
}
