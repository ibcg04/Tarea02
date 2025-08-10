package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModeradorTest {
    @Test
    void testResolverReporteSinNextHandler() {
        Moderador m = new Moderador();
        Reporte r = new Reporte(null, "Incidente");
        m.resolverReporte(r);
        assertTrue(r.isResuelto());
    }

    @Test
    void testResolverReporteConNextHandler() {
        Moderador m = new Moderador();
        SoporteLegal soporte = new SoporteLegal();
        m.setNextHandler(soporte);
        Reporte r = new Reporte(null, "Incidente");
        m.resolverReporte(r);
        assertTrue(r.isResuelto());
    }
}
