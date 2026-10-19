import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ContarPalabrasFileChooser {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int respuesta = chooser.showOpenDialog(null);

        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();

            try {
                int total = contarPalabras(archivo);
                System.out.println("El archivo tiene " + total + " palabras.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            }
        }
    }

    public static int contarPalabras(File archivo) throws IOException {
        int contador = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    String[] palabras = linea.split("\\s+");
                    contador += palabras.length;
                }
            }
        }

        return contador;
    }
}
