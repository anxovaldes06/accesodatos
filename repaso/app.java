package repaso;


public class app {
    
    public static void main(String[] args) {
         modelo m = new modelo();
        System.out.println(m.getTexto());
    }

        // c) Si mensaje deja de ser público no se podrá acceder a 
        // el desde la clase app, solo desde la misma clase si es 
        // private o subclases si es protected.
}
