package ej9;

public class Producto implements Gestionable {
    private String id;
    private boolean activo;

    public Producto(String id) {
        this.id = id;
        this.activo = false;
    }

    public String getIdentificador() {
        return id;
    }

    public void activar() {
        activo = true;
        System.out.println("Producto " + id + " activado");
    }

    public void desactivar() {
        activo = false;
        System.out.println("Producto " + id + " desactivado");
    }
}
