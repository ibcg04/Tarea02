package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class PropiedadTest {
    @Test
    void testAgregarUnidad() {
        Propiedad p = new Propiedad("Quito", new ArrayList<>(), null, new ArrayList<>());
        Unidad u = new Unidad();
        p.agregarUnidad(u);
        assertTrue(p.getUnidades().contains(u));
    }

    @Test
    void testAgregarReseña() {
        Propiedad p = new Propiedad("Quito", new ArrayList<>(), null, new ArrayList<>());
        Reseña r = new Reseña(5, "Muy buena", null);
        p.agregarReseña(r);
        assertTrue(p.getReseñas().contains(r));
    }
}
