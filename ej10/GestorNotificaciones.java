package ej10;

public class GestorNotificaciones {
    public void enviarNotificacion(ServicioNotificacion servicio, String destinatario, String mensaje) {
        if (servicio.validarDestinatario(destinatario)) {
            servicio.enviar(destinatario, mensaje);
        } else {
            System.out.println("Destinatario no válido para este servicio");
        }
    }
}
