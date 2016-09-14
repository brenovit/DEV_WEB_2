
package Src;

public class Ponto {
    private int x;
    private int y;

    public Ponto() {
        this.x = 0;
        this.y = 0;        
    }

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return " Ponto{" + " x = " + this.x + ", y = " + this.y + '}';
    }
    
    
    
       
}
