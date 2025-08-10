package modelo;

import java.util.ArrayList;

public class Propiedad {
    private final String ubicacion;
    private ArrayList<Unidad> unidades;
    private Anfitrion propietario;
    private ArrayList<Reseña> reseñas;

    public void setUnidades(ArrayList<Unidad> unidades) {
        this.unidades = unidades;
    }
    public void setPropietario(Anfitrion propietario) {
        this.propietario = propietario;
    }
    public void setReseñas(ArrayList<Reseña> reseñas) {
        this.reseñas = reseñas;
    }

    public Propiedad(String ubicacion, ArrayList<Unidad> unidades, Anfitrion propietario, ArrayList<Reseña> reseñas) {
        this.ubicacion = ubicacion;
        this.unidades = unidades;
        this.propietario = propietario;
        this.reseñas = reseñas;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Unidad> getUnidades() {
        return unidades;
    }

    public Anfitrion getPropietario() {
        return propietario;
    }

    public ArrayList<Reseña> getReseñas() {
        return reseñas;
    }

    @Override
    public String toString() {
    return "Propiedad en " + ubicacion + ", propietario: " + (propietario != null ? propietario.getNombre() : "Sin asignar") + ", unidades: " + (unidades != null ? unidades.size() : 0) + ", reseñas: " + (reseñas != null ? reseñas.size() : 0);
    }   
    // Agrega dentro de la clase Propiedad



    public void mostrarUnidades() {
        System.out.println("Unidades disponibles:");
        int enumeration = 1;
        for (Unidad u : unidades) {
            System.out.println(enumeration+".- "+u);
        }
    }

    public void agregarUnidad(Unidad unidad) {
        if (unidad == null) {
            System.out.println("[ADVERTENCIA] Unidad nula. No se agrega a la propiedad.");
            return;
        }
        unidades.add(unidad);
        System.out.println("Unidad agregada a la propiedad.");
    }

    public void agregarReseña(Reseña reseña) {
        if (reseña == null) {
            System.out.println("[ADVERTENCIA] Reseña nula. No se agrega a la propiedad.");
            return;
        }
        reseñas.add(reseña);
        System.out.println("Reseña agregada a la propiedad.");
    }

    public void mostrarReseñas() {
        if (reseñas.isEmpty()) {
            System.out.println("No hay reseñas para esta propiedad.");
        } else {
            System.out.println("Reseñas de la propiedad:");
            for (Reseña r : reseñas) {
                System.out.println("- " + r.getCalificacion() + ": " + r.getDescripcion());
            }
        }
    }
}
