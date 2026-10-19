package ej8;

public class Empleado_fijo extends Empleado {
    public Empleado_fijo(String nombre, double salarioBase) {
        super(nombre, salarioBase);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase();
    }
}
