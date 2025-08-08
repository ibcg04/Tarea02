package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Anfitrion extends Usuario implements ResuelveReporte {
    private ArrayList<Propiedad> propiedades;
    
    /* Getters */
    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }
    public int getID() {
        return super.getID();
    }

    public Anfitrion(String nombre, int id) {
        super(nombre, id);
        this.propiedades = new ArrayList<>();
    }

    public Regla establecerregla(String descripcion){
        return new Regla(descripcion);
    }
    public Regla establecerHorarioCheck(Date checkIn, Date checkOut){
        return new CheckInCheckOut(checkIn,checkOut);
    }
    public Regla establecerRestriccion(String restriccion){
        return new Restriccion(restriccion);
    }


    public Reseña reseñar(int calificacion, String descripcion){
        return new Reseña(calificacion, descripcion, this);
    }

    @Override
    public void resolverReporte(Reporte r) {
        // Implementación útil: mostrar el reporte y marcarlo como resuelto
        System.out.println("Resolviendo reporte:");
        System.out.println("Autor: " + r.getAutor().getNombre());
        System.out.println("Mensaje: " + r.getMensaje());
        r.setResuelto(true);
        System.out.println("Incidente resuelto.");
    }
    public void mostrarPropiedades() {
    if (propiedades.isEmpty()) {
        System.out.println("No tienes propiedades registradas.");
    } else {
        System.out.println("Tus propiedades:");
        for (Propiedad p : propiedades) {
            System.out.println(p);
        }
    }
    
}
@Override
public String toString() {
    return "Anfitrion: " + getNombre() + " (ID: " + getID() + ")";
}
// Agrega dentro de la clase Anfitrion

public void agregarPropiedad(Propiedad propiedad) {
    propiedades.add(propiedad);
    System.out.println("Propiedad agregada exitosamente.");
}

    public void eliminarPropiedad(Propiedad propiedad) {
        if (propiedades.remove(propiedad)) {
            System.out.println("Propiedad eliminada exitosamente.");
        } else {
            System.out.println("La propiedad no existe en tu lista.");
        }
    }

    public void mostrarReseñas() {
        System.out.println("Reseñas recibidas:");
        for (Propiedad p : propiedades) {
            for (Reseña r : p.getReseñas()) {
                System.out.println(r);
            }
        }
    }

   


}