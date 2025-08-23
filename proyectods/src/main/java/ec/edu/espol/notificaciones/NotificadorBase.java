package ec.edu.espol.notificaciones;

public class NotificadorBase extends Notificador {
    private Notificador notificador;

    public NotificadorBase(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando: " + mensaje);
    }
}
