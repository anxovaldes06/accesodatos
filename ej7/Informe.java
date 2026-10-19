package ej7;

public class Informe implements imprimible {
    private String nombre;
    private String contenido;

    public Informe(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe: " + nombre);
        System.out.println("Contenido: " +contenido);
    }
}
