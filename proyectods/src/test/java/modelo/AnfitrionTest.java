package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

class AnfitrionTest {
    private Anfitrion anfitrion;

    @BeforeEach
    void setUp() {
        anfitrion = new Anfitrion("Juan", 1);
    }

    @Test
    void testEstablecerRegla() {
        Regla regla = anfitrion.establecerregla("No fumar");
        assertEquals("No fumar", regla.getDescripcion());
    }

    @Test
    void testEstablecerHorarioCheck() {
        Date in = new Date();
        Date out = new Date(in.getTime() + 10000);
        Regla regla = anfitrion.establecerHorarioCheck(in, out);
        assertTrue(regla.getDescripcion().contains(in.toString()));
        assertTrue(regla.getDescripcion().contains(out.toString()));
    }

    @Test
    void testEstablecerRestriccion() {
        Regla regla = anfitrion.establecerRestriccion("No mascotas");
        assertEquals("No mascotas", regla.getDescripcion());
    }

    @Test
    void testReseñarSinAutor() {
        Reseña r = anfitrion.reseñar(5, "Excelente");
        assertEquals(5, r.getCalificacion());
        assertEquals("Excelente", r.getDescripcion());
    }

    @Test
    void testReseñarConAutor() {
        Usuario autor = new Usuario("Pedro", 2);
        Reseña r = anfitrion.reseñar(4, "Bueno", autor);
        assertEquals(4, r.getCalificacion());
        assertEquals("Bueno", r.getDescripcion());
        assertEquals(autor, r.getAutor());
    }
}
