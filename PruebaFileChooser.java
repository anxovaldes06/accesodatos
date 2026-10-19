
import javax.swing.*;
import java.io.File;

public class PruebaFileChooser {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("/users/Antonio/Desktop"));
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.getCurrentDirectory();
        int seleccion = fileChooser.showOpenDialog(null);

        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            File[] elementos = archivoSeleccionado.listFiles();
            for (File elemento : elementos) {

                if (elemento.isFile()) {
                    System.out.println(elemento.getName() + " - Fichero");
                    
                }
                if(elemento.isDirectory()){
                    System.out.println(elemento.getName() + " - Directorio");
                    File[] subdirectorios = elemento.listFiles();
                    if(subdirectorios == null){
                        return;
                    }
                    for(File subdirectorio : subdirectorios){
                    if(subdirectorio.isFile()){
                        System.out.println(subdirectorio.getName() + " - Fichero");
                   
                    }

                    }

                
                    }
                }

            }
        }
    }
