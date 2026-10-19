package geometria;

public class rectangulo {
     
    private int ancho = 1;
    private int alto = 1;

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        if ( ancho > 0) {
            this.ancho = ancho; // Se asigna el valor del parámetro al atributo de la clase
        }
    }

    public void setAlto(int alto) {
        if ( alto > 1) {
            this.alto = alto; 
        }
    }

    public int area() {
        return ancho * alto;
    }

    public int perimetro() {
        return 2 * (ancho + alto);
    }

    public static void main(String[] args) {
        rectangulo r = new rectangulo();
        rectangulo r2 = new rectangulo();
        r2.setAncho(0);
        r2.setAlto(-4);    
        r.setAncho(3);
        r.setAlto(6);
        System.out.println("Ancho: " + r.getAncho());
        System.out.println("Alto: " + r.getAlto());
        System.out.println("Area: " + r.area());
        System.out.println("Perimetro: " + r.perimetro());
        System.out.println("Ancho: " + r2.getAncho());
        System.out.println("Alto: " + r2.getAlto());
        System.out.println("Area: " + r2.area());
        System.out.println("Perimetro: " + r2.perimetro());
    }
}
