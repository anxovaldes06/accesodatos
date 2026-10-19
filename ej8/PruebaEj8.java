package ej8;

public class PruebaEj8 {
    public static void main(String[] args) {
        EmpleadoFijo fijo = new EmpleadoFijo("Luis", 1800);
        Comercial comercial = new Comercial("Ana", 1500, 5000);

        System.out.println("Empleado fijo:");
        fijo.mostrarDatos();
        System.out.println("Salario final: " + fijo.calcularSalario());

        System.out.println("\nComercial:");
        comercial.mostrarDatos();
        System.out.println("Bonificación: " + comercial.bonificacion());
        System.out.println("Salario final: " + comercial.calcularSalario());

        Bonificable bonus = comercial;
        System.out.println("\nBonificación desde la interfaz: " + bonus.bonificacion());
    }
}
