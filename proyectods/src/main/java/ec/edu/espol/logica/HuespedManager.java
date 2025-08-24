package ec.edu.espol.logica;

import java.util.ArrayList;

import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.BaseDatos;
import ec.edu.espol.modelo.Huesped;
import ec.edu.espol.modelo.Propiedad;
import ec.edu.espol.modelo.Unidad;

public class HuespedManager {
    public HuespedManager(){
        throw new IllegalStateException("Utility Class");
    }

    // Lógica de negocio: reservar una unidad para un huésped
    public static void reservarUnidad(Huesped huesped, Unidad unidad) {
        if (huesped != null && unidad != null) {
            huesped.reservar(unidad);
        }
    }

    // ...otros métodos de lógica de negocio...
    // Puedes refactorizar mostrarPropiedades para que solo devuelva la lista, sin imprimir
    public static ArrayList<Propiedad> obtenerPropiedadesDisponibles() {
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        for(Anfitrion a: BaseDatos.getDataBase().getAnfitriones().values()){
            propiedades.addAll(a.getPropiedades());
        }
        return propiedades;
    }

    // El método reservarPropiedad y mostrarPropiedades con interacción de usuario deben migrar a la UI
    // Lógica de negocio para generar reseña
    public static boolean generarReseña(Huesped huesped, int calificacion, String descripcion) {
        if (huesped.getUnidadOcupada() != null) {
            Anfitrion anfi =  huesped.getUnidadOcupada().getPropiedad().getPropietario();
            huesped.reseñar(calificacion, descripcion, anfi);
            return true;
        }
        return false;
    }

    // Lógica de negocio para reportar incidente
    public static void reportarIncidente(Huesped huesped, String mensaje) {
        if (huesped != null && mensaje != null && !mensaje.isEmpty()) {
            huesped.reportar(mensaje);
        }
    }



    
}

