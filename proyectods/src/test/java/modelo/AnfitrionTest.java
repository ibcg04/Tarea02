package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.Regla;
import ec.edu.espol.modelo.Reseña;
import ec.edu.espol.modelo.Usuario;
import ec.edu.espol.modelo.Propiedad;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

class AnfitrionTest {
    private Anfitrion anfitrion;

    @BeforeEach
    void setUp() {
        anfitrion = new Anfitrion("Juan", 1);
    }

    @Test
    @DisplayName("Crea una regla con descripción válida")
    void testEstablecerRegla() {
        Regla regla = anfitrion.establecerregla("No fumar");
        assertEquals("No fumar", regla.getDescripcion());
    }

    @Test
    @DisplayName("Crea una regla de horario con fechas válidas")
    void testEstablecerHorarioCheck() {
        Date in = new Date();
        Date out = new Date(in.getTime() + 10000);
        Regla regla = anfitrion.establecerHorarioCheck(in, out);
        assertTrue(regla.getDescripcion().contains(in.toString()));
        assertTrue(regla.getDescripcion().contains(out.toString()));
    }

    @Test
    @DisplayName("Crea una restricción con texto válido")
    void testEstablecerRestriccion() {
        Regla regla = anfitrion.establecerRestriccion("No mascotas");
        assertEquals("No mascotas", regla.getDescripcion());
    }

    @Test
    @DisplayName("Crea una reseña sin autor")
    void testReseñarSinAutor() {
        Reseña r = anfitrion.reseñar(5, "Excelente");
        assertEquals(5, r.getCalificacion());
        assertEquals("Excelente", r.getDescripcion());
    }

    @Test
    @DisplayName("Crea una reseña con autor")
    void testReseñarConAutor() {
        Usuario autor = new Usuario("Pedro", 2);
        Reseña r = anfitrion.reseñar(4, "Bueno", autor);
        assertEquals(4, r.getCalificacion());
        assertEquals("Bueno", r.getDescripcion());
        assertEquals(autor, r.getAutor());
    }

    @Test
    @DisplayName("Regla con descripción nula retorna regla vacía")
    void testEstablecerReglaConDescripcionNula() {
        Regla regla = anfitrion.establecerregla(null);
        assertEquals("", regla.getDescripcion());
    }

    @Test
    @DisplayName("Restricción nula retorna regla vacía")
    void testEstablecerRestriccionNula() {
        Regla regla = anfitrion.establecerRestriccion(null);
        assertEquals("", regla.getDescripcion());
    }

    @Test
    @DisplayName("Reseñar con descripción nula retorna reseña vacía")
    void testReseñarDescripcionNula() {
        Reseña r = anfitrion.reseñar(5, null);
        assertEquals("", r.getDescripcion());
    }

        @Test
        @DisplayName("Eliminar propiedad la elimina de la lista")
        void testEliminarPropiedad() {
            Anfitrion anfitrion = new Anfitrion("Juan", 1);
            Propiedad propiedad = new Propiedad("Quito", new ArrayList<>(), anfitrion, new ArrayList<>());
            anfitrion.agregarPropiedad(propiedad);
            anfitrion.eliminarPropiedad(propiedad);
            assertFalse(anfitrion.getPropiedades().contains(propiedad));
        }
}
