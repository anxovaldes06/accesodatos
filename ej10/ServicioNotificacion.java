package ej10;

public interface ServicioNotificacion {
    boolean validarDestinatario(String destinatario);
    void enviar(String destinatario, String mensaje);
}
