package ec.edu.espol;

public class Sms extends NotificadorBase {

    public Sms(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
