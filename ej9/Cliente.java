package ej9;

public class Cliente implements Gestionable {
    private String id;
    private boolean activo;

    public Cliente(String id) {
        this.id = id;
        this.activo = false;
    }

    public String getIdentificador() {
        return id;
    }

    public void activar() {
        activo = true;
        System.out.println("Cliente " + id + " activado");
    }

    public void desactivar() {
        activo = false;
        System.out.println("Cliente " + id + " desactivado");
    }
}
