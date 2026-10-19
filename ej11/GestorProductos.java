package ej11;

import java.util.ArrayList;
import java.util.List;

public class GestorProductos implements Gestor<Producto> {
    private List<Producto> productos = new ArrayList<>();

    @Override
    public void anadir(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto buscar(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String codigo) {
        Producto producto = buscar(codigo);
        if (producto != null) {
            productos.remove(producto);
        }
    }

    @Override
    public List<Producto> listar() {
        return productos;
    }
}
