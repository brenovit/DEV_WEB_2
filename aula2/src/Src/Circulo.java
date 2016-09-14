package Src;

public class Circulo extends Ponto {

    protected double raio;

    public Circulo() {
        setRaio(0);
    }

    public Circulo(double raio, int xc, int yc) {
        super(xc, yc);
        setRaio(raio);
    }

    public void setRaio(double raio) {
        if (raio > 0) {
            this.raio = raio;
        } else {
            this.raio = 0;
        }
    }

    public String toString() {
        return ("raio: " + raio + " " + super.toString());
    }
}
