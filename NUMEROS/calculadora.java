package NUMEROS;

public class calculadora {
    
    public void sumar(int a, int b) {
        System.out.println("Suma: " + (a + b));
    }

    public void sumar(int a, int b, int c) {
        System.out.println("Suma: " + (a + b + c));
    }

      public void sumar(double a, double b) {
        System.out.println("Suma: " + (a + b));
    }
   

    
    
    //no se puede añadir el metodo double sumar con int a, int b,
    //  porque ya existe el metodo sumar con int a, int b, y no se puede 
    // sobrecargar un metodo con el mismo nombre y los mismos parametros.

    //se puede añadir el metodo double sumar si se cambian los parametros y no estan repetidos,
    //  por ejemplo: double sumar(double a, double b) si no existia el metodo sumar con double a, double b.
    public static void main(String[] args) {
        calculadora calc = new calculadora();
        calc.sumar(2, 3);          // Llama al método sumar(int, int)
        calc.sumar(2, 3, 4);       // Llama al método sumar(int, int, int)
        calc.sumar(2.5, 3.0);      // Llama al método sumar(double, double)
    }
}
