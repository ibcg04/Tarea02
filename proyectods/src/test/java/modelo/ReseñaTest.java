package modelo;

import org.junit.jupiter.api.Test;

import ec.edu.espol.modelo.Reseña;
import ec.edu.espol.modelo.Usuario;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ReseñaTest {
    @Test
    @DisplayName("toString contiene los datos de la reseña")
    void testToString() {
        Usuario autor = new Usuario("Ana", 1);
        Reseña r = new Reseña(4, "Muy bien", autor);
        String s = r.toString();
        assertTrue(s.contains("Muy bien"));
        assertTrue(s.contains("4"));
        assertTrue(s.contains("Ana"));
    }

    @Test
    @DisplayName("Constructor con descripción nula asigna vacío")
    void testConstructorDescripcionNula() {
        Usuario autor = new Usuario("Ana", 1);
        Reseña r = new Reseña(4, null, autor);
        assertEquals("", r.getDescripcion());
    }

    @Test
    @DisplayName("setCalificacion actualiza la calificación correctamente")
    void testSetCalificacion() {
        Usuario autor = new Usuario("Ana", 1);
        Reseña r = new Reseña(4, "Muy bien", autor);
        r.setCalificacion(2);
        assertEquals(2, r.getCalificacion());
    }
}
