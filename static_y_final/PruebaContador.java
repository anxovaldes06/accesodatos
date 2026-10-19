package static_y_final;

public class PruebaContador {

    // Primero se ejecuta el bloque estático de la clase Contador, despues se ejecuta el main de la clase PruebaContador.
    public static void main(String[] nombre) {
        System.out.println(Contador.getTotal());
        
        Contador a = new Contador();
        Contador b = new Contador();
        Contador.leerNombre(a);
        Contador.leerNombre(b);
        System.out.println(Contador.getTotal());
    }
}