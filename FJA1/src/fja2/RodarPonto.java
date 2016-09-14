/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fja2;

import Src.Circulo;
import Src.Ponto;

/**
 *
 * @author solaris
 */
public class RodarPonto {
    public static void Executar(){
        Ponto p0 = new Ponto();
        Ponto p1;
        p1 = new Ponto(12, 78);      
                      
        System.out.println(p0);
        System.out.println(p1);
        
        Ponto p2, p3;
        Circulo c2, c3;
        
        p2 = new Ponto(99, 88);        
        c2 = new Circulo(123.456, 33, 22 );
        
        System.out.println(p2);
        System.out.println(c2);
        
        p3 = c2;
        System.out.println(p3);
        
        c3 = (Circulo)p3; 
        System.out.println(c3);
    }
}
