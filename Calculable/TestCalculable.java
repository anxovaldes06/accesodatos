package Calculable;

public class TestCalculable{

    public static void main ( String [] args){

    Circulo c1= new Circulo();
    Circulo c2 = new Circulo();
    Rectángulo r1 = new Rectángulo();

        System.out.println("Área círculos : ");
        System.out.println( c1.calcularArea(5));
        System.out.println( c2.calcularArea(10));
        System.out.println("Área rectángulos : ");
        System.out.println( r1.calcularArea(5,6));
    }
}