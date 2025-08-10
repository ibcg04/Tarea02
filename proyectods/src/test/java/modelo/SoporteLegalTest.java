package modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class SoporteLegalTest {
    @Test
    @DisplayName("Resuelve el reporte y lo marca como resuelto")
    void testResolverReporte() {
        SoporteLegal soporte = new SoporteLegal();
        Reporte reporte = new Reporte(null, "Incidente");
        soporte.resolverReporte(reporte);
        assertTrue(reporte.isResuelto());
    }

    @Test
    @DisplayName("Lanza excepción al resolver reporte nulo")
    void testResolverReporteNulo() {
        SoporteLegal soporte = new SoporteLegal();
        assertThrows(NullPointerException.class, () -> soporte.resolverReporte(null));
    }
}
