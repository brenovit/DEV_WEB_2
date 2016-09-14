package Src;

public class Ponto {

    protected int x, y;

    public Ponto() {
        this.x = 0;
        this.y = 0;
    }

    public Ponto(int xc, int yc) {
        this.x = xc;
        this.y = yc;
    }

    public String toString() {
        return ("[x: " + this.x + ", y: " + this.y + "]");
    }
}
