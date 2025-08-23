package ec.edu.espol.notificaciones;

public class Mensajeria extends NotificadorBase{
    public Mensajeria(Notificador notificador) {
        super(notificador);
    }

    @Override
    public void notificar(String mensaje) {
        System.out.println("Enviando mensaje: " + mensaje);
    }
}
