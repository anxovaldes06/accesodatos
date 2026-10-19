package documento;

public class empleado {

    private String nombre;
    private String dni;

    public empleado() {
        this.nombre = "";
        this.dni = "";
    }

    public empleado(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    // Si el parámetro se llama igual que el atributo, entonces
    // nombre = nombre; no inicializa el atributo de la clase,
    // porque el parámetro "nombre" oculta al atributo.
    // Para acceder al atributo de la clase se usa this.nombre.
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public static void main(String[] args) {
        empleado e1 = new empleado("PACO", "125312422N");
        empleado e2 = new empleado("MANOLO", "212145123G");

        e1.setNombre("PAQUITO PACO");

        System.out.println("Empleado 1: " + e1.getNombre() + " - " + e1.getDni());
        System.out.println("Empleado 2: " + e2.getNombre() + " - " + e2.getDni());

        
    }
}
