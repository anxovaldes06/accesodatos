package banco;

public class Tienda {
    public void mostrarAcceso(cuenta c) {
        // c.saldo = 100;    // Error: saldo es private
        // c.codigo = "002"; // OK si estamos en el mismo paquete
        // c.oficina = "Sevilla"; // OK si estamos en el mismo paquete
        c.titular = "Luis"; // OK porque titular es public

        System.out.println("codigo: " + c.codigo);
        System.out.println("oficina: " + c.oficina);
        System.out.println("titular: " + c.titular);
    }
}
