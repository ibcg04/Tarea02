package modelo;

import org.junit.jupiter.api.BeforeEach;
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
    void testReservarUnidad() {
        huesped.reservar(unidad);
        assertEquals(huesped, unidad.getOcupante());
        assertEquals(unidad, huesped.getUnidadOcupada());
    }

    @Test
    void testReseñarSinAutor() {
        Reseña r = huesped.reseñar(3, "Regular");
        assertEquals(3, r.getCalificacion());
        assertEquals("Regular", r.getDescripcion());
    }

    @Test
    void testReseñarConAutor() {
        Usuario autor = new Usuario("Pedro", 3);
        Reseña r = huesped.reseñar(2, "Malo", autor);
        assertEquals(2, r.getCalificacion());
        assertEquals("Malo", r.getDescripcion());
        assertEquals(autor, r.getAutor());
    }

    @Test
    void testReportar() {
        huesped.reportar("Incidente grave");
        // Aquí se podría verificar que el reporte fue creado, si hay acceso a la lista de reportes
    }

    @Test
    void testBuscarPropiedades() {
        ArrayList<Propiedad> propiedades = huesped.buscarPropiedades("Quito", 4);
        assertNotNull(propiedades);
    }
}
