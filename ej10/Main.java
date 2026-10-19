package ej10;

public class Main {
    public static void main(String[] args) {
        GestorNotificaciones gestor = new GestorNotificaciones();

        ServicioNotificacion email = new Email();
        ServicioNotificacion sms = new Sms();
        ServicioNotificacion app = new AppNotification();

        gestor.enviarNotificacion(email, "ana@correo.com", "Hola, tienes un mensaje");
        gestor.enviarNotificacion(sms, "123456789", "Tu pedido está listo");
        gestor.enviarNotificacion(app, "ana", "Nuevo mensaje recibido");
    }
}
