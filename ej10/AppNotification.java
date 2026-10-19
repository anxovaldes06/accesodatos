package ej10;

public class AppNotification implements ServicioNotificacion {
    @Override
    public boolean validarDestinatario(String destinatario) {
        return destinatario.length() >= 3;
    }

    @Override
    public void enviar(String destinatario, String mensaje) {
        if (validarDestinatario(destinatario)) {
            System.out.println("Enviando notificación a la app: " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else {
            System.out.println("Usuario de la app no válido: " + destinatario);
        }
    }
}
