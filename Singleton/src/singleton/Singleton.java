package singleton;

public class Singleton {
    public static void main(String[] args) {
       Pessoa p1 = Pessoa.otemPessoa();
       
       p1.setNome("Breno");
       p1.setCpf("07049603546");
       p1.setRg("1530421683");
       
       System.out.println(p1);
       
       Pessoa p2 = Pessoa.otemPessoa();
       p2.setNome("Mauricio");
       p2.setCpf("123456781529");
       p2.setRg("0123654987");
       
       System.out.println(p2);
       System.out.println(p1);
    }
    
}
