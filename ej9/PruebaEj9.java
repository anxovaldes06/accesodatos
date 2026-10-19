package ej9;

import java.util.ArrayList;
import java.util.List;

public class PruebaEj9 {
    public static void main(String[] args) {
        List<Gestionable> lista = new ArrayList<>();

        lista.add(new Producto("#01"));
        lista.add(new Cliente("#04"));
        lista.add(new Producto("#012"));

        for (Gestionable objeto : lista) {
            System.out.println("Identificador: " + objeto.getIdentificador());
            objeto.activar();
            objeto.desactivar();
            System.out.println("--------------------");
        }
    }
}
