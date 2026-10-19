package static_y_final;

public class Contador {
   private static int total = 0;
   private String nombre;
   public static final int MAX = 3;

   public Contador() {
      this("PACO");
   }

   public Contador(String nombre) {
      ++total;
      this.nombre = nombre;
   }

   public static String leerNombre(Contador contador) {
      return contador.nombre;
   }

   public static int getTotal() {
      return total;
   }

   static {
      System.out.println("Carga");
   }
}
