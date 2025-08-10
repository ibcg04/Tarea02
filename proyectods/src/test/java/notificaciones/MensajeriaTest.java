package notificaciones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class MensajeriaTest {
    @Test
    @DisplayName("Notifica por mensajería con mensaje válido")
    void testNotificar() {
        Mensajeria m = new Mensajeria(null);
        m.notificar("Hola");
        // Verifica que no lanza excepción y se imprime el mensaje
    }

    @Test
    @DisplayName("Notifica por mensajería con mensaje vacío")
    void testNotificarMensajeVacio() {
        Mensajeria m = new Mensajeria(null);
        m.notificar("");
        // No debe lanzar excepción
    }
}
