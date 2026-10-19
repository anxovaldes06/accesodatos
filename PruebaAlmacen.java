public class PruebaAlmacen {
 
    public static void main(String[] args) {
        Almacen almacen = new Almacen(10);
        System.out.println("Meter 8: " + almacen.meter(8));
        System.out.println("Meter 12: " + almacen.meter(12));
        System.out.println("Sacar 2: " + almacen.sacar(2));
        System.out.println("Sacar 13: " + almacen.sacar(13));
        almacen.rellenar();
        System.out.println("Sacar 9: " + almacen.sacar(9));
      
    }
}
