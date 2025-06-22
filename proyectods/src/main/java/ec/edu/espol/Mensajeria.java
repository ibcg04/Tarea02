package ec.edu.espol;

public class Mensajeria extends NotificadorBase{
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando mensaje: " + mensaje);
    }
}
