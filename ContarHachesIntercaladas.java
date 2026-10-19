import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ContarHachesIntercaladas{

    public static void main ( String [] args){

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int respuesta = chooser.showOpenDialog(null);
         if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            try {
                int total = contarHachesIntercaladas(archivo);
                System.out.println("El archivo tiene " + total + " palabras con haches intercaladas");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
        }
    }

    public static int contarHachesIntercaladas(File archivo) throws IOException {
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.split("\\s+");

                    for (String palabra : palabras) {
                        String p = palabra.toLowerCase();
                        if (p.contains("h") && !p.startsWith("h") && !p.contains("ch")) {
                            contador++;
                        }
                    }
                }
            }
        }

        return contador;
    }

}