package notificaciones;

import org.junit.jupiter.api.Test;
import ec.edu.espol.notificaciones.Mensajeria;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.DisplayName;

class MensajeriaTest {
    @Test
    @DisplayName("Notifica por mensajería con mensaje válido")
    void testNotificar() {
        Mensajeria m = new Mensajeria(null);
        assertDoesNotThrow(() -> m.notificar("Hola"));
    }

    @Test
    @DisplayName("Notifica por mensajería con mensaje vacío")
    void testNotificarMensajeVacio() {
        Mensajeria m = new Mensajeria(null);
        m.notificar("");
        // No debe lanzar excepción
    }
}
