package aula2;

import Src.Ponto;

public class TestaPonto {

    public static void main(String[] args) {
        Ponto m, n, b;

        m = new Ponto();
        n = new Ponto(19, 21);
        b = n;

        System.out.println("ponto m: " + m);
        System.out.println("ponto n: " + n);
        System.out.println("ponto b: " + b);
    }
}
