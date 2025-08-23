package logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.logica.HuespedManager;
import ec.edu.espol.modelo.*;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HuespedManagerTest {
    private HuespedManager manager;
    private Huesped huesped;
    private Scanner sc;

    @BeforeEach
    void setUp() {
        manager = new HuespedManager();
        huesped = new Huesped("Test", 1);
        sc = new Scanner(System.in);
    }

    @Test
    @DisplayName("Retorna lista de unidades con precio menor o igual al máximo (caso normal)")
    void testPrecioMaxNormal() {
    ArrayList<Unidad> unidades = HuespedManager.buscarPrecioMaximo(1000.0);
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Retorna lista vacía si el precio máximo es negativo")
    void testPrecioMaxNegativo() {
    ArrayList<Unidad> unidades = HuespedManager.buscarPrecioMaximo(-10.0);
        assertTrue(unidades.isEmpty());
    }

    @Test
    @DisplayName("Busca unidades por ubicación válida")
    void testUbicacionSearchNormal() {
    ArrayList<Unidad> unidades = HuespedManager.busquedaPorUbicacion("Quito");
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Busca unidades con ubicación vacía")
    void testUbicacionSearchVacia() {
    ArrayList<Unidad> unidades = HuespedManager.busquedaPorUbicacion("");
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Lanza excepción si la ubicación es nula")
    void testUbicacionSearchNula() {
    assertThrows(NullPointerException.class, () -> HuespedManager.busquedaPorUbicacion(null));
    }

    @Test
    @DisplayName("Lanza excepción si la ubicación es nula en buscarPorUbicacion")
    void testBuscarPorUbicacionNula() {
    assertThrows(NullPointerException.class, () -> HuespedManager.buscarPorUbicacion(null, sc, huesped));
    }

    @Test
    @DisplayName("No lanza excepción al buscar por precio negativo")
    void testBuscarPorPrecioNegativo() {
    assertDoesNotThrow(() -> HuespedManager.buscarPorPrecio(-100, sc, huesped));
    }

    @Test
    @DisplayName("No lanza excepción al buscar por precio válido")
    void testBuscarPorPrecioNormal() {
    assertDoesNotThrow(() -> HuespedManager.buscarPorPrecio(100, sc, huesped));
    }
}
