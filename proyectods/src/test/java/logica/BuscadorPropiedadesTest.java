package logica;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ec.edu.espol.logica.BuscadorPropiedades;
import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.BaseDatos;
import ec.edu.espol.modelo.Propiedad;
import ec.edu.espol.modelo.Reseña;
import ec.edu.espol.modelo.Servicio;
import ec.edu.espol.modelo.Unidad;


class BuscadorPropiedadesTest {

    private Anfitrion anfitrion;
    private Propiedad propiedad;
    private Unidad unidad;

    @BeforeEach
    void setUp() {
        BaseDatos.getDataBase().getAnfitriones().clear();

        anfitrion = new Anfitrion("Juan", 1);
        ArrayList<Unidad> unidades = new ArrayList<>();
        unidad = new Unidad() {
            @Override
            public boolean estaDisponible() { return true; }
        };
        unidad.setPrecio(100);
        unidad.setPropiedad(null);
        unidades.add(unidad);

        ArrayList<Reseña> reseñas = new ArrayList<>();
        propiedad = new Propiedad("Quito", unidades, anfitrion, reseñas);
        ArrayList<Servicio> servicios = new ArrayList<>();
        servicios.add(Servicio.WiFi);
        servicios.add(Servicio.Piscina);
        propiedad.setServicios(servicios);
        unidad.setPropiedad(propiedad);

        anfitrion.getPropiedades().add(propiedad);
        BaseDatos.getDataBase().getAnfitriones().put(33, anfitrion);
    }

    @Test
    @DisplayName("buscarPorUbicacion retorna unidades disponibles en la ubicación dada")
    void testBuscarPorUbicacionConCoincidencias() {
        List<Unidad> resultado = BuscadorPropiedades.buscarPorUbicacion("Quito");
        assertEquals(1, resultado.size());
        assertEquals(unidad, resultado.get(0));
    }

    @Test
    @DisplayName("buscarPorUbicacion retorna lista vacía si no hay coincidencias")
    void testBuscarPorUbicacionSinCoincidencias() {
        List<Unidad> resultado = BuscadorPropiedades.buscarPorUbicacion("Guayaquil");
        assertTrue(resultado.isEmpty());
    }

    @Test
    @DisplayName("buscarPorUbicacion lanza excepción si ubicación es null")
    void testBuscarPorUbicacionNull() {
        assertThrows(NullPointerException.class, () -> BuscadorPropiedades.buscarPorUbicacion(null));
    }

    @Test
    @DisplayName("buscarPorPrecio retorna unidades con precio menor o igual al dado")
    void testBuscarPorPrecioConCoincidencias() {
        List<Unidad> resultado = BuscadorPropiedades.buscarPorPrecio(150);
        assertEquals(1, resultado.size());
        assertEquals(unidad, resultado.get(0));
    }

    @Test
    @DisplayName("buscarPorPrecio retorna lista vacía si no hay coincidencias")
    void testBuscarPorPrecioSinCoincidencias() {
        List<Unidad> resultado = BuscadorPropiedades.buscarPorPrecio(50);
        assertTrue(resultado.isEmpty());
    }

    @Test
    @DisplayName("buscarPorTipo lanza excepción si tipoPropiedad es null")
    void testBuscarPorTipoNull() {
        assertThrows(NullPointerException.class, () -> BuscadorPropiedades.buscarPorTipo(null));
    }

    @Test
    @DisplayName("buscarPorServicio retorna propiedades que ofrecen el servicio buscado")
    void testBuscarPorServicioConCoincidencias() {
        List<Propiedad> resultado = BuscadorPropiedades.buscarPorServicio("WIFI");
        assertEquals(1, resultado.size());
        assertEquals(propiedad, resultado.get(0));
    }

    @Test
    @DisplayName("buscarPorServicio retorna lista vacía si no hay coincidencias")
    void testBuscarPorServicioSinCoincidencias() {
        List<Propiedad> resultado = BuscadorPropiedades.buscarPorServicio("GYM");
        assertTrue(resultado.isEmpty());
    }

    @Test
    @DisplayName("buscarPorServicio lanza excepción si servicioBuscado es null")
    void testBuscarPorServicioNull() {
        assertThrows(NullPointerException.class, () -> BuscadorPropiedades.buscarPorServicio(null));
    }
}