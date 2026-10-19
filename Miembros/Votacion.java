package Miembros;

public class Votacion {
    private String nombre;
    private int votos;
    private static String nombreMasVotado;
    private static int votosMasVotado = 0;

    public Votacion(String nombre) {
        this.nombre = nombre;
        this.votos = 0;
    }

    public void votar() {
        votos++;
        if (votos > votosMasVotado) {
            votosMasVotado = votos;
            nombreMasVotado = nombre;
        }
        
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    public static String getNombreMasVotado() {
        return nombreMasVotado;
    }

    public static int getVotosMasVotado() {
        return votosMasVotado;
    }

    public static String getLider() {
        return nombreMasVotado;
    }

    public static void main(String[] args) {
        Votacion Ana = new Votacion("Ana");
        Votacion Bruno = new Votacion("Bruno");
        Votacion Carla = new Votacion("Carla");
        System.out.println( Votacion.getLider());
        Ana.votar();
        Bruno.votar();
        Bruno.votar();
        Carla.votar();
        Carla.votar();
        Ana.votar();
        Ana.votar();
        System.out.println( Votacion.getLider());
    }

   
}