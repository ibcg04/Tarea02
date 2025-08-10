package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class HuespedTest {
    private Huesped huesped;
    private Unidad unidad;

    @BeforeEach
    void setUp() {
        huesped = new Huesped("Maria", 2);
        unidad = new Unidad();
    }

    @Test
    @DisplayName("Reserva una unidad disponible")
    void testReservarUnidad() {
        unidad.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);
        huesped.reservar(unidad);
        assertEquals(huesped, unidad.getOcupante());
        assertEquals(unidad, huesped.getUnidadOcupada());
        assertTrue(huesped.getHistorialReservas().contains(unidad));
    }

    @Test
    @DisplayName("Crea reseña sin autor")
    void testReseñarSinAutor() {
        Reseña r = huesped.reseñar(3, "Regular");
        assertEquals(3, r.getCalificacion());
        assertEquals("Regular", r.getDescripcion());
    }

    @Test
    @DisplayName("Crea reseña con autor")
    void testReseñarConAutor() {
        Usuario autor = new Usuario("Pedro", 3);
        Reseña r = huesped.reseñar(2, "Malo", autor);
        assertEquals(2, r.getCalificacion());
        assertEquals("Malo", r.getDescripcion());
        assertEquals(autor, r.getAutor());
    }

    @Test
    @DisplayName("No lanza excepción al reservar unidad nula")
    void testReservarUnidadNula() {
        assertDoesNotThrow(() -> huesped.reservar(null));
    }

    @Test
    @DisplayName("Reseñar con descripción nula retorna reseña vacía")
    void testReseñarDescripcionNula() {
        Reseña r = huesped.reseñar(1, null);
        assertEquals("", r.getDescripcion());
    }

    @Test
    @DisplayName("No lanza excepción al reportar mensaje nulo")
    void testReportarMensajeNulo() {
        assertDoesNotThrow(() -> huesped.reportar(null));
    }

    @Test
    @DisplayName("Busca propiedades por ubicación y calificación")
    void testBuscarPropiedades() {
        ArrayList<Propiedad> propiedades = huesped.buscarPropiedades("Quito", 4);
        assertNotNull(propiedades);
    }
}
