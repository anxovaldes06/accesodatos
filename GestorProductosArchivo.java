import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class GestorProductosArchivo {

    private static final String ARCHIVO = "productos.dat";
    private static final int TAMANO_REGISTRO = 40;
    private static final int TAMANO_NOMBRE = 12;
    private static final String[] NOMBRES = {
            "Martillo", "Taladro", "Sierra", "Cuchilla", "Llave"
    };
    private static final int[] EXISTENCIAS = {10, 5, 8, 3, 12};
    private static final double[] PRECIOS = {25.50, 150.00, 90.75, 18.20, 35.00};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            escribirProductos();
            mostrarProductos();

            System.out.println("Introduce el identificador del producto:");
            int identificador = sc.nextInt();
            mostrarProducto(identificador);

            System.out.println("Introduce el identificador del producto:");
            int identificadorStock = sc.nextInt();
            System.out.println("Introduce la nueva cantidad de existencias:");
            int existencias = sc.nextInt();
            actualizarExistencias(identificadorStock, existencias);

            System.out.println("Introduce el identificador del producto:");
            int identificadorPrecio = sc.nextInt();
            System.out.println("Introduce el nuevo precio:");
            double precio = sc.nextDouble();
            actualizarPrecio(identificadorPrecio, precio);

            System.out.println("Productos modificados:");
            mostrarProductos();
        } catch (IOException e) {
            System.out.println("Error al trabajar con el fichero: " + e.getMessage());
        }
    }

    private static void escribirProductos() throws IOException {
        try (RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, "rw")) {
            archivo.setLength(0);

            for (int i = 0; i < NOMBRES.length; i++) {
                String nombre = ajustarNombre(NOMBRES[i]);
                archivo.writeInt(i + 1);
                archivo.writeChars(nombre);
                archivo.writeInt(EXISTENCIAS[i]);
                archivo.writeDouble(PRECIOS[i]);
            }

            System.out.println("Productos guardados en " + ARCHIVO);
        }
    }

    private static String ajustarNombre(String nombre) {
        if (nombre.length() > TAMANO_NOMBRE) {
            return nombre.substring(0, TAMANO_NOMBRE);
        }

        StringBuilder nombreAjustado = new StringBuilder(nombre);
        while (nombreAjustado.length() < TAMANO_NOMBRE) {
            nombreAjustado.append(' ');
        }
        return nombreAjustado.toString();
    }

    private static void mostrarProductos() throws IOException {
        try (RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, "r")) {
            for (int i = 0; i < NOMBRES.length; i++) {
                Producto producto = leerProducto(archivo, i + 1);
                System.out.println(producto);
            }
        }
    }

    private static void mostrarProducto(int identificador) throws IOException {
        try (RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, "r")) {
            if (!validarIdentificador(identificador, NOMBRES.length)) {
                return;
            }

            Producto producto = leerProducto(archivo, identificador);
            System.out.println(producto);
        }
    }

    private static Producto leerProducto(RandomAccessFile archivo, int identificador) throws IOException {
        long posicion = (long) (identificador - 1) * TAMANO_REGISTRO;
        archivo.seek(posicion);

        int id = archivo.readInt();
        char[] caracteres = new char[TAMANO_NOMBRE];
        for (int i = 0; i < TAMANO_NOMBRE; i++) {
            caracteres[i] = archivo.readChar();
        }
        int existencias = archivo.readInt();
        double precio = archivo.readDouble();

        return new Producto(id, new String(caracteres).trim(), existencias, precio);
    }

    private static void actualizarExistencias(int identificador, int existencias) throws IOException {
        if (!validarIdentificador(identificador, NOMBRES.length)) {
            return;
        }
        if (existencias < 0) {
            System.out.println("La cantidad de existencias no puede ser negativa.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, "rw")) {
            long posicion = (long) (identificador - 1) * TAMANO_REGISTRO;
            archivo.seek(posicion + 28);
            archivo.writeInt(existencias);
            System.out.println("Existencias actualizadas.");
        }
    }

    private static void actualizarPrecio(int identificador, double precio) throws IOException {
        if (!validarIdentificador(identificador, NOMBRES.length)) {
            return;
        }
        if (precio < 0) {
            System.out.println("El precio no puede ser negativo.");
            return;
        }

        try (RandomAccessFile archivo = new RandomAccessFile(ARCHIVO, "rw")) {
            long posicion = (long) (identificador - 1) * TAMANO_REGISTRO;
            archivo.seek(posicion + 32);
            archivo.writeDouble(precio);
            System.out.println("Precio actualizado.");
        }
    }

    private static boolean validarIdentificador(int identificador, int numeroRegistros) {
        if (identificador < 1 || identificador > numeroRegistros) {
            System.out.println("El identificador debe estar entre 1 y " + numeroRegistros + ".");
            return false;
        }
        return true;
    }

    private static class Producto {
        private int identificador;
        private String nombre;
        private int existencias;
        private double precio;

        private Producto(int identificador, String nombre, int existencias, double precio) {
            this.identificador = identificador;
            this.nombre = nombre;
            this.existencias = existencias;
            this.precio = precio;
        }

        @Override
        public String toString() {
            return "Identificador: " + identificador
                    + ", Nombre: " + nombre
                    + ", Existencias: " + existencias
                    + ", Precio: " + precio;
        }
    }
}
