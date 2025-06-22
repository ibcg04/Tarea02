package ec.edu.espol;

public class Sms extends NotificadorBase {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}
