
import java.io.*;
import java.util.Scanner;

public class EscrituraNumEnteros {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("pareja_numeros.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce parejas de enteros, una por línea.");
        System.out.println("Escribe INTRO para finalizar.");

        while (true) {
            System.out.print("Pareja de enteros: ");
            String linea = sc.nextLine();

            if (linea.trim().startsWith("INTRO")) {
                break;
            }

            String[] numeros = linea.trim().split("\\s+");

            if (numeros.length == 2) {
                bw.write(numeros[0] + " " + numeros[1]);
                bw.newLine();
            }
        }

        bw.close();
        sc.close();
        System.out.println("Archivo guardado en pareja_numeros.txt");
    }
}