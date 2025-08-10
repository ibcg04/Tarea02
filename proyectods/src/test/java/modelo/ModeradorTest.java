package modelo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ModeradorTest {
    @Test
    @DisplayName("Resuelve el reporte sin nextHandler")
    void testResolverReporteSinNextHandler() {
        Moderador m = new Moderador();
        Reporte r = new Reporte(null, "Incidente");
        m.resolverReporte(r);
        assertTrue(r.isResuelto());
    }

    @Test
    @DisplayName("Resuelve el reporte delegando a nextHandler")
    void testResolverReporteConNextHandler() {
        Moderador m = new Moderador();
        SoporteLegal soporte = new SoporteLegal();
        m.setNextHandler(soporte);
        Reporte r = new Reporte(null, "Incidente");
        m.resolverReporte(r);
        assertTrue(r.isResuelto());
    }

    @Test
    @DisplayName("Lanza excepción al resolver reporte nulo")
    void testResolverReporteNulo() {
        Moderador m = new Moderador();
        assertThrows(NullPointerException.class, () -> m.resolverReporte(null));
    }
}
