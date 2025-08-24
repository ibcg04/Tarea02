package notificaciones;

import org.junit.jupiter.api.Test;

import ec.edu.espol.notificaciones.Sms;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class SmsTest {
    @Test
    @DisplayName("Notifica por SMS con mensaje válido")
    void testNotificar() {
        Sms sms = new Sms(null);
        assertDoesNotThrow(() -> sms.notificar("Hola"));
    }

    @Test
    @DisplayName("No lanza excepción al notificar mensaje nulo")
    void testNotificarMensajeNulo() {
        Sms sms = new Sms(null);
        assertDoesNotThrow(() -> sms.notificar(null));
    }
}
