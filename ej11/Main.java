package ej11;

public class Main {
    public static void main(String[] args) {
        Gestor<Producto> gestorProductos = new GestorProductos();
        Gestor<Cliente> gestorClientes = new GestorClientes();

        gestorProductos.anadir(new Producto("P1", "Teclado"));
        gestorProductos.anadir(new Producto("P2", "Ratón"));

        gestorClientes.anadir(new Cliente("111", "Ana"));
        gestorClientes.anadir(new Cliente("222", "Luis"));

        System.out.println("Productos:");
        for (Producto p : gestorProductos.listar()) {
            System.out.println(p);
        }

        System.out.println("\nClientes:");
        for (Cliente c : gestorClientes.listar()) {
            System.out.println(c);
        }

        System.out.println("\nBuscar producto P2:");
        System.out.println(gestorProductos.buscar("P2"));

        System.out.println("\nBuscar cliente 222:");
        System.out.println(gestorClientes.buscar("222"));

        gestorProductos.eliminar("P1");
        gestorClientes.eliminar("111");

        System.out.println("\nDespués de eliminar:");
        System.out.println(gestorProductos.listar());
        System.out.println(gestorClientes.listar());
    }
}
