package ej11;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes implements Gestor<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void anadir(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscar(String dni) {
        for (Cliente c : clientes) {
            if (c.getDni().equals(dni)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public void eliminar(String dni) {
        Cliente cliente = buscar(dni);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }

    @Override
    public List<Cliente> listar() {
        return clientes;
    }
}
