package ej7;

public class PruebaEj7 {
    public static void main(String[] args) {
        Factura factura = new Factura( "Paco", 170);
        Informe informe = new Informe("Mensual", "dinero recaudado total este mes");

      factura.imprimir();
      System.out.println(factura.obtenerResumen());
      informe.imprimir();

    }
}
