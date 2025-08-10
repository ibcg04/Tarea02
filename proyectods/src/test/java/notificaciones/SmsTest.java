package notificaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmsTest {
    @Test
    void testNotificar() {
        Sms sms = new Sms(null);
        sms.notificar("Hola");
        // Verifica que no lanza excepción y se imprime el mensaje
    }
}
