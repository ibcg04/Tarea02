package ec.edu.espol.notificaciones;

public class Sms extends NotificadorBase {

    public Sms(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensaje) {
        if (mensaje == null) {
            System.out.println("[ADVERTENCIA] mensaje no puede ser null, no se envía SMS.");
            return;
        }
        System.out.println("Enviando SMS: " + mensaje);
    }
}
