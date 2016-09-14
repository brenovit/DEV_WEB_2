
package Src;

public class Circulo extends Ponto{
    private double raio;

    public Circulo() {
        this.setRaio(0);
    }

    public Circulo(double raio) {
        this.raio = raio;
    }

    public Circulo(double raio, int x, int y) {
        super(x, y);
        this.raio = raio;
    }
    
    public void setRaio(double raio) {
        if (raio > 0){ 
            this.raio = raio;
        }else{
            this.raio = 0;
        }
    }

    @Override
    public String toString() {
        return "Circulo{" + "raio = " + this.raio + super.toString() + '}';
    }
    
       
    
}
