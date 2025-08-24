package logica;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
