package ej8;

public class Comercial extends Empleado implements Bonificable {
    private double ventas;

    public Comercial(String nombre, double salarioBase, double ventas) {
        super(nombre, salarioBase);
        this.ventas = ventas;
    }

    public double getVentas() {
        return ventas;
    }

    public void setVentas(double ventas) {
        this.ventas = ventas;
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonificacion();
    }

    @Override
    public double bonificacion() {
        return ventas * 0.10;
    }
}
