package banco;

public class CuentaHija extends cuenta {
    public void mostrarOficinaDesdeSubclase() {
        // Acceso a un miembro heredado protected desde una subclase
        System.out.println("Oficina heredada: " + this.oficina);
    }
}
