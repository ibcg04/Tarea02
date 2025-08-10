package modelo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;

public class Anfitrion extends Usuario implements ResuelveReporte {
    private ArrayList<Propiedad> propiedades;
    private ArrayList<Huesped> historialOcupantes;
    private ArrayDeque<Reporte> reportes;
    private ResuelveReporte nextHandler; //Chain of Responsibility
    
    /* Getters Y Setters */
    public ArrayList<Huesped> getHistorialOcupantes() {
    return historialOcupantes;
    }
    public void setHistorialOcupantes(ArrayList<Huesped> historialOcupantes) {
        this.historialOcupantes = historialOcupantes;
    }
    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }
    public int getID() {
        return super.getID();
    }

    public Anfitrion(String nombre, int id) {
        super(nombre, id);
        this.propiedades = new ArrayList<>();
        this.historialOcupantes = new ArrayList<>();
    }
    public void setNextHandler(ResuelveReporte nextHandler) {
        this.nextHandler = nextHandler;
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

    public Reseña reseñar(int calificacion, String descripcion, Usuario autor){
        return new Reseña(calificacion, descripcion, autor);
    }


    @Override
    public void resolverReporte(Reporte r) {
        String msg;
            if (r.getMensaje() == null) {
                msg = "";
            } else {
                msg = r.getMensaje().toLowerCase();
            }
            
      boolean puedoResolver = msg.contains("limpieza") || msg.contains("ruido")
                         || msg.contains("wifi")     || msg.contains("toalla");

        
        if (puedoResolver) {
            System.out.println("Anfitrión resuelve el incidente.");
            r.setResuelto(true);
            return;
        }
        // Si no puede atender, delega al siguiente si existe.
        if (nextHandler != null) {
            System.out.println("Anfitrión delega el reporte...");
            nextHandler.resolverReporte(r);
        } else {
            System.out.println("Anfitrión no pudo resolver y no hay a quién delegar.");
        }
    }
    public void mostrarPropiedades() {
        if (propiedades.isEmpty()) {
            System.out.println("No tienes propiedades registradas.");
        } else {
            System.out.println("Tus propiedades:");
            int enumeration = 1;
            for (Propiedad p : propiedades) {
                System.out.println(enumeration + ".-" + p);
                enumeration++;
            }
        }
    
    }
    public ArrayDeque<Reporte> getReportes() {
        if (this.reportes == null) {
            this.reportes = new ArrayDeque<>();
        }
        return this.reportes;
    }
    public void setReportes(ArrayDeque<Reporte> reportes) {
    this.reportes = reportes;
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

    @Override
    public void mostrarReseñas() {
        System.out.println("Reseñas recibidas:");
        for (Propiedad p : propiedades) {
            for (Reseña r : p.getReseñas()) {
                System.out.println(r);
            }
        }
    }


    public void mostrarHistorialOcupantes() {
        System.out.println("Historial de ocupantes:");
        if (historialOcupantes.isEmpty()) {
            System.out.println("No hay ocupantes registrados.");
        } else {
            int enumeration = 1;
            for (Huesped h : historialOcupantes) {
                System.out.println(enumeration+".-"+h.getNombre());
            }
        }
    }
}