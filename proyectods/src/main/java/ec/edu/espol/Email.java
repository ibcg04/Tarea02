package ec.edu.espol;

public class Email extends NotificadorBase{
    public Email(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando correo electrónico: " + mensaje);
    }
}
