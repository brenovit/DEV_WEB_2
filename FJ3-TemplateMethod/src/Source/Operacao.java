package Source;
/**
 *
 * @author Breno
 */
abstract public class Operacao {
    /*
        template method é uma classe abstrata que cria o escopo de um metodo abstrato que será implementado
        em outras classes concretas, de forma obrigatoria   
    */
    
    //metodo abstrato que será implementado nas classes sub
    abstract public int handleOperacao(int val1, int val2);
    
    //metodo concreto que será usado pela classe super, por intermedio da classe sub
    public void efetueOperacao(int val1, int val2){
        int result = handleOperacao(val1, val2);
    }
}