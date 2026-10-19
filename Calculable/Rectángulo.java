package Calculable;

public class Rectángulo {
    
    private double base;
    private double altura;

    public double getBase(){
        return base;
    }

     public double getAltura(){
        return altura;
    }

     public double setAltura(double altura){
            return this.altura=altura;
    }

     public double setBase(double base){
            return this.base=base;
    }




    public double calcularArea(double base, double altura){
        return base * altura;
    }
}
