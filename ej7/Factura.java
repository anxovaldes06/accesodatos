package ej7;

public class Factura implements imprimible, Resumible {
    private String cliente;
    private double cantidad_total;

    public Factura( String cliente, double cantidad_total) {
        this.cliente = cliente;
        this.cantidad_total = cantidad_total;
    }

    @Override
    public void imprimir() {
        System.out.println("Cliente: " + cliente);
        System.out.println("Total: " + cantidad_total + " $");
    }

    @Override
    public String obtenerResumen() {
        return " Cliente: " + cliente + " - Total: " + cantidad_total + " $";
    }
}
