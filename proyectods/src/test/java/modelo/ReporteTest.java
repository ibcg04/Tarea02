package modelo;

import org.junit.jupiter.api.Test;

import ec.edu.espol.modelo.Reporte;
import ec.edu.espol.modelo.Huesped;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ReporteTest {
    @Test
    @DisplayName("Marca el reporte como resuelto")
    void testSetResuelto() {
        Reporte r = new Reporte(null, "Mensaje");
        r.setResuelto(true);
        assertTrue(r.isResuelto());
    }

    @Test
    @DisplayName("Constructor con mensaje nulo asigna vacío")
    void testConstructorMensajeNulo() {
        Reporte r = new Reporte(null, null);
        assertEquals("", r.getMensaje());
    }

        @Test
        @DisplayName("getAutor retorna el autor correctamente")
        void testGetAutor() {
            Huesped autor = new Huesped("Carlos", 1);
            Reporte r = new Reporte(autor, "Mensaje");
            assertEquals(autor, r.getAutor());
        }
}
