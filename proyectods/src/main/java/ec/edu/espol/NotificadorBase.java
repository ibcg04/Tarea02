package ec.edu.espol;

public class NotificadorBase extends Notificador {
    private Notificador notificador;

    public NotificadorBase(Notificador notificador) {
        this.notificador = notificador;
    }

    @Override
    public void notificar(String mensaje) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
