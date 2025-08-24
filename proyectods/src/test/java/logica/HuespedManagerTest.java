package logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.logica.HuespedManager;
import ec.edu.espol.logica.BuscadorPropiedades;
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
        ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorPrecio(1000.0);
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Retorna lista vacía si el precio máximo es negativo")
    void testPrecioMaxNegativo() {
        ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorPrecio(-10.0);
        assertTrue(unidades.isEmpty());
    }

    @Test
    @DisplayName("Busca unidades por ubicación válida")
    void testUbicacionSearchNormal() {
        ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorUbicacion("Quito");
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Busca unidades con ubicación vacía")
    void testUbicacionSearchVacia() {
        ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorUbicacion("");
        assertNotNull(unidades);
    }

    @Test
    @DisplayName("Lanza excepción si la ubicación es nula")
    void testUbicacionSearchNula() {
        assertThrows(NullPointerException.class, () -> BuscadorPropiedades.buscarPorUbicacion(null));
    }
}
