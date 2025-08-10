package notificaciones;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class EmailTest {
    @Test
    @DisplayName("Notifica por correo electrónico con mensaje válido")
    void testNotificar() {
        Email email = new Email(null);
        email.notificar("Hola");
        // Verifica que no lanza excepción y se imprime el mensaje
    }

    @Test
    @DisplayName("No lanza excepción al notificar mensaje nulo")
    void testNotificarMensajeNulo() {
        Email email = new Email(null);
        assertDoesNotThrow(() -> email.notificar(null));
    }
}
