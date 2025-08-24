package ec.edu.espol.logica;

import java.util.ArrayList;

import ec.edu.espol.modelo.Propiedad;
import ec.edu.espol.modelo.Unidad;
import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.BaseDatos;

public class BuscadorPropiedades {
    private BuscadorPropiedades() {
        throw new IllegalStateException("Utility Class");
    }

    public static ArrayList<Unidad> buscarPorUbicacion(String ubicacion) {
        ArrayList<Unidad> unidades = new ArrayList<>();
        if (ubicacion == null) throw new NullPointerException("ubicacion no puede ser null");
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                for (Unidad unidad : propiedad.getUnidades()) {
                    if (unidad.estaDisponible() && unidad.getPropiedad().getUbicacion().equalsIgnoreCase(ubicacion)) {
                        unidades.add(unidad);
                    }
                }
            }
        }
        return unidades;
    }

    public static ArrayList<Unidad> buscarPorPrecio(double precioMaximo) {
        ArrayList<Unidad> unidades = new ArrayList<>();
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                for (Unidad unidad : propiedad.getUnidades()) {
                    if (unidad.estaDisponible() && unidad.getPrecio() <= precioMaximo) {
                        unidades.add(unidad);
                    }
                }
            }
        }
        return unidades;
    }

    public static ArrayList<Unidad> buscarPorTipo(String tipoPropiedad) {
        ArrayList<Unidad> unidades = new ArrayList<>();
        if (tipoPropiedad == null) throw new NullPointerException("tipoPropiedad no puede ser null");
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                for (Unidad unidad : propiedad.getUnidades()) {
                    boolean agregar = false;
                    switch (tipoPropiedad.toUpperCase()) {
                        case "CASA":
                            agregar = unidad.getClass().getSimpleName().equalsIgnoreCase("Casa") && unidad.estaDisponible();
                            break;
                        case "DEPARTAMENTO":
                            agregar = unidad.getClass().getSimpleName().equalsIgnoreCase("DepartamentoCompleto") && unidad.estaDisponible();
                            break;
                        case "HABITACION":
                            agregar = unidad.getClass().getSimpleName().equalsIgnoreCase("HabitacionPrivada") && unidad.estaDisponible();
                            break;
                        default:
                            break;
                    }
                    if (agregar) {
                        unidades.add(unidad);
                    }
                }
            }
        }
        return unidades;
    }

    public static ArrayList<Propiedad> buscarPorServicio(String servicioBuscado) {
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        if (servicioBuscado == null) throw new NullPointerException("servicioBuscado no puede ser null");
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                boolean encontrado = false;
                for (var servicio : propiedad.getServicios()) {
                    if (servicio.name().equalsIgnoreCase(servicioBuscado)) {
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    propiedades.add(propiedad);
                }
            }
        }
        return propiedades;
    }
}
