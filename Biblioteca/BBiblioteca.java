package Biblioteca;
class Publicacion {
    private String titulo;
    private int anio;
    private boolean prestada;

    public Publicacion(String titulo, int anio, boolean prestada) {
        this.titulo = titulo;
        this.anio = anio;
        this.prestada = prestada;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isPrestada() {
        return prestada;
    }

    public void setPrestada(boolean prestada) {
        this.prestada = prestada;
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + "', anio=" + anio + ", prestada=" + prestada;
    }
}

class Libro extends Publicacion {
    private String autor;

    public Libro(String titulo, int anio, boolean prestada, String autor) {
        super(titulo, anio, prestada);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro: " + super.toString() + ", autor='" + autor + "'";
    }
}

class Revista extends Publicacion {
    private int numero;

    public Revista(String titulo, int anio, boolean prestada, int numero) {
        super(titulo, anio, prestada);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Revista: " + super.toString() + ", numero=" + numero;
    }
}

public class BBiblioteca implements Biblioteca {

    @Override
    public int cuentaPrestados(Publicacion[] publicaciones) {
        int numeroPrestados = 0;
        for (Publicacion publicacion : publicaciones) {
            if (publicacion != null && publicacion.isPrestada()) {
                numeroPrestados++;
            }
        }
        return numeroPrestados;
    }

    @Override
    public int publicacionesAnterioresA(Publicacion[] publicaciones, int anio) {
        int numeroPublicaciones = 0;
        for (Publicacion publicacion : publicaciones) {
            if (publicacion != null && publicacion.getAnio() < anio) {
                numeroPublicaciones++;
            }
        }
        return numeroPublicaciones;
    }

    public static void main(String[] args) {
        Publicacion[] publicaciones = new Publicacion[4];

        publicaciones[0] = new Libro("El Quijote", 1605, false, "Miguel de Cervantes");
        publicaciones[1] = new Libro("Aprendiendo Java", 2021, true, "Ana López");
        publicaciones[2] = new Revista("National Geographic", 1988, false, 120);
        publicaciones[3] = new Revista("Computer Hoy", 2023, false, 45);

        BBiblioteca biblioteca = new BBiblioteca();

        System.out.println("Datos almacenados en el array:");
        for (Publicacion publicacion : publicaciones) {
            System.out.println(publicacion);
        }

        System.out.println("Hay " + biblioteca.cuentaPrestados(publicaciones) + " publicaciones prestadas.");
        System.out.println("Hay " + biblioteca.publicacionesAnterioresA(publicaciones, 1990) + " publicaciones anteriores a 1990.");
    }
}
