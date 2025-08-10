package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReseñaTest {
    @Test
    void testToString() {
        Usuario autor = new Usuario("Ana", 1);
        Reseña r = new Reseña(4, "Muy bien", autor);
        String s = r.toString();
        assertTrue(s.contains("Muy bien"));
        assertTrue(s.contains("4"));
        assertTrue(s.contains("Ana"));
    }
}
