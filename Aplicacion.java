import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Numerador: ");
            int num = sc.nextInt();

            System.out.print("Denominador: ");
            int den  = sc.nextInt();

            if (num  >= 100 ){
                throw new ExcepcionIntervalo("Numerador debe ser menor que 100");
            }
            else if(den <=-5){
                throw new ExcepcionIntervalo("Denominador debe ser mayor que -5");
            }
            else if(den == 0){
                throw new ExcepcionIntervalo("Denominador no puede ser igual a 0");
            }
            else{
            System.out.println("Operación realiza con éxito");
            }
            System.out.println("Resultado : ");
            double resultado = (double)num/den;
            System.out.println(resultado);
            
        } catch (ExcepcionIntervalo e) {
            System.out.println(e.getMessage());
            
        }
        catch(InputMismatchException e){
            System.out.println("ERROR : formato no válido");

        }
    }
}