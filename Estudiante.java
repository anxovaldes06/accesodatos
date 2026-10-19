import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Estudiante implements Serializable {
    private String nombre;
    private int edad;
    private double notaMedia;
    private transient String contraseña;
     
    private static final long serialVersionUID = 1L;

    public Estudiante(String nombre, int edad , double notaMedia, String contraseña){
            this.nombre=nombre;
            this.edad=edad;
            this.notaMedia=notaMedia;
            this.contraseña=contraseña;

    }



    public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public int getEdad() {
    return edad;
}

public void setEdad(int edad) {
    this.edad = edad;
}

public double getNotaMedia() {
    return notaMedia;
}

public void setNotaMedia(double notaMedia) {
    this.notaMedia = notaMedia;
}

public String getContraseña() {
    return contraseña;
}

public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
}


    @Override 
    public String toString(){
        return "Nombre : " +nombre+ ", edad : " +edad + ", notaMedia : " +notaMedia+ ", contraseña : " +contraseña ;


    }

    public static void main ( String [] args){
        FileOutputStream fs = null;
        ObjectOutputStream os = null;

        try {   Estudiante es1 =  new Estudiante("Paco", 43, 7, "alfredita123");
                Estudiante es2 =  new Estudiante("Manuela", 45, 8, "manolito123");
                Estudiante es3 =  new Estudiante("Manolo", 52, 6.7, "manuelita123");
              ArrayList<Estudiante> estudiantes = new ArrayList<>();
              estudiantes.add(es1);
              estudiantes.add(es2);
              estudiantes.add(es3);



                fs = new FileOutputStream("estudiante.ser" );
                os = new ObjectOutputStream(fs);
                os.writeObject(estudiantes);
                os.close();

        }catch(FileNotFoundException fne){
            System.out.println("No existe el fichero");
        } catch(IOException ioe){
            System.out.println(" ERROR E/L");
        }
        System.out.println("FIN DE LA ESCRITURA");



        try {
            FileInputStream fis =new FileInputStream("estudiante.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Estudiante> estudiantes = (ArrayList<Estudiante>) ois.readObject();

            for (Estudiante estudiante : estudiantes) {
                 System.out.println(estudiante);
                                            }   
            ois.close();

        }catch(ClassNotFoundException cfe){
System.out.println("Clase no encontrada");
}catch(IOException ioe){
System.out.println("Error E/L");
}
System.out.println("FIN DE LA ESCRITURA");

}
}

