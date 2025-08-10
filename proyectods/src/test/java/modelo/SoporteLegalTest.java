package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SoporteLegalTest {
    @Test
    void testResolverReporte() {
        SoporteLegal soporte = new SoporteLegal();
        Reporte reporte = new Reporte(null, "Incidente");
        soporte.resolverReporte(reporte);
        assertTrue(reporte.isResuelto());
    }
}
