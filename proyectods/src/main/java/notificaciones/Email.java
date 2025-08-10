package notificaciones;

public class Email extends NotificadorBase{
    public Email(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensaje) {
        if (mensaje == null) {
            System.out.println("[ADVERTENCIA] Mensaje nulo. No se envía correo electrónico.");
            return;
        }
        System.out.println("Enviando correo electrónico: " + mensaje);
    }
}
