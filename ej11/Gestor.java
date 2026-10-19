package ej11;

import java.util.List;

public interface Gestor<T> {
    void anadir(T objeto);
    T buscar(String id);
    void eliminar(String id);
    List<T> listar();
}
