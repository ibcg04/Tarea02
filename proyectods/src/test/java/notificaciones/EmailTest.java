package notificaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    void testNotificar() {
        Email email = new Email(null);
        email.notificar("Hola");
        // Verifica que no lanza excepción y se imprime el mensaje
    }
}
