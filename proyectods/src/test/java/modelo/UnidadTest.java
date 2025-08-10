package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnidadTest {
    private Unidad unidad;

    @BeforeEach
    void setUp() {
        unidad = new Unidad();
    }

    @Test
    void testLiberarUnidad() {
        Huesped h = new Huesped("Carlos", 1);
        unidad.setOcupante(h);
        unidad.liberarUnidad();
        assertNull(unidad.getOcupante());
    }

    @Test
    void testMarcarEnMantenimiento() {
        unidad.marcarEnMantenimiento();
        assertEquals(EstadoAlojamiento.EN_MANTENIMIENTO, unidad.getEstadoAlojamiento());
    }

    @Test
    void testMarcarFueraDeServicio() {
        unidad.marcarFueraDeServicio();
        assertEquals(EstadoAlojamiento.FUERA_DE_SERVICIO, unidad.getEstadoAlojamiento());
    }
}
