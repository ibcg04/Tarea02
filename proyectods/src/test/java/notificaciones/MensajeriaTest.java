package notificaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MensajeriaTest {
    @Test
    void testNotificar() {
        Mensajeria m = new Mensajeria(null);
        m.notificar("Hola");
        // Verifica que no lanza excepción y se imprime el mensaje
    }
}
