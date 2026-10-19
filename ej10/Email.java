package ej10;

public class Email implements ServicioNotificacion {
    @Override
    public boolean validarDestinatario(String destinatario) {
        return destinatario.contains("@") && destinatario.contains(".");
    }

    @Override
    public void enviar(String destinatario, String mensaje) {
        if (validarDestinatario(destinatario)) {
            System.out.println("Enviando email a: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Email no válido: " + destinatario);
        }
    }
}
