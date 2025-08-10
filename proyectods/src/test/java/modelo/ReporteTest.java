package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReporteTest {
    @Test
    void testSetResuelto() {
        Reporte r = new Reporte(null, "Mensaje");
        r.setResuelto(true);
        assertTrue(r.isResuelto());
    }
}
