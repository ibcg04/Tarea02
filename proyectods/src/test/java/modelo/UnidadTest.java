package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ec.edu.espol.modelo.Unidad;
import ec.edu.espol.modelo.Huesped;
import ec.edu.espol.modelo.EstadoAlojamiento;

class UnidadTest {
    private Unidad unidad;

    @BeforeEach
    void setUp() {
        unidad = new Unidad();
    }

    @Test
    @DisplayName("Libera la unidad correctamente")
    void testLiberarUnidad() {
        Huesped h = new Huesped("Carlos", 1);
        unidad.setOcupante(h);
        unidad.liberarUnidad();
        assertNull(unidad.getOcupante());
    }

    @Test
    @DisplayName("Marca la unidad en mantenimiento")
    void testMarcarEnMantenimiento() {
        unidad.marcarEnMantenimiento();
        assertEquals(EstadoAlojamiento.EN_MANTENIMIENTO, unidad.getEstadoAlojamiento());
    }

    @Test
    @DisplayName("Marca la unidad fuera de servicio")
    void testMarcarFueraDeServicio() {
        unidad.marcarFueraDeServicio();
        assertEquals(EstadoAlojamiento.FUERA_DE_SERVICIO, unidad.getEstadoAlojamiento());
    }

    @Test
    @DisplayName("Permite setear ocupante nulo")
    void testSetOcupanteNulo() {
        unidad.setOcupante(null);
        assertNull(unidad.getOcupante());
    }

    @Test
    @DisplayName("Permite setear propiedad nula")
    void testSetPropiedadNula() {
        unidad.setPropiedad(null);
        assertNull(unidad.getPropiedad());
    }
    
    @Test
    @DisplayName("estaDisponible retorna true si la unidad está disponible")
    void testEstaDisponible() {
        Unidad unidad = new Unidad();
        unidad.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);
        assertTrue(unidad.estaDisponible());
    }
}
