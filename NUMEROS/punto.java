package NUMEROS;

public class punto {
    private int x;
    private int y;

    public punto() {
        this(0, 0);
    }

    public punto(int v) {
        this(v, v);
    }

    public punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void dibujar() {
        System.out.println("Punto(" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        punto p1 = new punto();
        punto p2 = new punto(4);
        punto p3 = new punto(4, 6);

        System.out.println("p1 = (" + p1.getX() + ", " + p1.getY() + ")");
        System.out.println("p2 = (" + p2.getX() + ", " + p2.getY() + ")");
        System.out.println("p3 = (" + p3.getX() + ", " + p3.getY() + ")");

        p1.dibujar();
        p2.dibujar();
        p3.dibujar();
    }
}
