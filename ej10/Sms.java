package ej10;

public class Sms implements ServicioNotificacion {
    @Override
    public boolean validarDestinatario(String destinatario) {
        return destinatario.matches("\\d{9}");
    }

    @Override
    public void enviar(String destinatario, String mensaje) {
        if (validarDestinatario(destinatario)) {
            System.out.println("Enviando SMS al: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Número de teléfono no válido: " + destinatario);
        }
    }
}
