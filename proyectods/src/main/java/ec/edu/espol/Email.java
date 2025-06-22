package ec.edu.espol;

public class Email extends NotificadorBase{
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando email: " + mensaje);
    }
}
