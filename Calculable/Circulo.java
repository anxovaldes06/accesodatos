package Calculable;

public class Circulo {

    private double radio;
    private final static double  PI = 3.14;

    public double getPI(){
        return PI;
    }

    public double getRadio(){
        return radio;
    }

    public double setRadio(double radio){
            return this.radio=radio;
    }

    public double calcularArea(double radio){
        return PI * Math.pow(radio, 2);

    }
    
}
