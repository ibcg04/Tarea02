package logica;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ec.edu.espol.modelo.Reporte;

import ec.edu.espol.logica.AnfitrionManager;
import ec.edu.espol.modelo.Anfitrion;

class AnfitrionManagerTest {
    private Anfitrion anfitrion;
    private Scanner sc;

    @BeforeEach
    void setUp() {
        anfitrion = new Anfitrion("Anfitrion", 1);
        sc = new Scanner(System.in);
    }

    @Test
    @DisplayName("No lanza excepción si el anfitrión no tiene propiedades")
    void testManejarPropiedadesSinPropiedades() {
        assertDoesNotThrow(() -> AnfitrionManager.manejarPropiedades(anfitrion, sc));
    }

    @Test
    @DisplayName("No lanza excepción si el anfitrión no tiene reportes")
    void testManejarIncidentesSinReportes() {
        assertDoesNotThrow(() -> AnfitrionManager.manejarIncidentes(anfitrion));
    }

    @Test
    @DisplayName("Lanza excepción si el anfitrión es nulo en manejarPropiedades")
    void testManejarPropiedadesNulo() {
        assertThrows(NullPointerException.class, () -> AnfitrionManager.manejarPropiedades(null, sc));
    }

    @Test
    @DisplayName("Lanza excepción si el anfitrión es nulo en manejarIncidentes")
    void testManejarIncidentesNulo() {
        assertThrows(NullPointerException.class, () -> AnfitrionManager.manejarIncidentes(null));
    }

    @Test
    @DisplayName("Lanza excepción si el anfitrión es nulo en generarReseña")
    void testGenerarReseñaNulo() {
        assertThrows(NullPointerException.class, () -> AnfitrionManager.generarReseña(null, sc));
    }

        @Test
        @DisplayName("manejarIncidentes procesa y resuelve un reporte pendiente")
        void testManejarIncidentesConReporte() {
            Anfitrion anfitrion = new Anfitrion("Anfitrion", 1);
            Reporte reporte = new Reporte(null, "Incidente de prueba");
            anfitrion.getReportes().add(reporte);
            assertDoesNotThrow(() -> AnfitrionManager.manejarIncidentes(anfitrion));
            assertTrue(reporte.isResuelto());
        }
}
