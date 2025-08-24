package logica;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ec.edu.espol.logica.BuscadorPropiedades;
import ec.edu.espol.modelo.*;
import ec.edu.espol.logica.HuespedManager;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class HuespedManagerTest {
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

    @Test
    @DisplayName("generarReseña retorna true si el huésped tiene unidad ocupada")
    void testGenerarReseñaTrue() {
        Anfitrion anfitrion = new Anfitrion("Anfitrión", 1);
        Propiedad propiedad = new Propiedad("Quito", new ArrayList<>(), anfitrion, new ArrayList<>());
        Unidad unidad = new Unidad();
        unidad.setPropiedad(propiedad);
        unidad.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);
        Huesped huesped = new Huesped("María", 2);
        propiedad.getUnidades().add(unidad);
        huesped.reservar(unidad);
        boolean resultado = HuespedManager.generarReseña(huesped, 5, "Excelente");
        assertTrue(resultado);
    }
}
