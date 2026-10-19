package Biblioteca;
public interface Biblioteca {
    int cuentaPrestados(Publicacion[] publicaciones);
    int publicacionesAnterioresA(Publicacion[] publicaciones, int anio);
}