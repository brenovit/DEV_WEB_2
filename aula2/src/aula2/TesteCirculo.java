package aula2;

import Src.Circulo;
import Src.Ponto;

public class TesteCirculo {

    public static void main(String[] args) {
        Ponto p1, p2;
        Circulo c1, c2;

        p1 = new Ponto(1, 0);
        c1 = new Circulo(1.75, 0, 1);

        System.out.println("Ponto p1 " + p1);
        System.out.println("Circulo c1 " + c1);

        //coersao (conversao) de super para sub        
        //c1(Circulo) é um p2(Ponto)
        p2 = c1;
        System.out.println("Ponto p2 (via Circulo) " + p2.toString());

        // coersao de sub para super
        c2 = (Circulo) p2;
        System.out.println("Circulo c2 " + c2);
        
        //verifica se o objeto p1 é uma instancia de Circulo
        if (p1 instanceof Circulo) {
            c2 = (Circulo) p1;
        } else {
            System.out.println("p1 nao é uma instância de Circulo");
        }
    }
}
