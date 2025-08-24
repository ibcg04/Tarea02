package ec.edu.espol.modelo;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private final int id;
    private ArrayList<Reseña> reseñas;

    /* Getters y Setters */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ArrayList<Reseña> getReseñas() {
        return new ArrayList<>(reseñas);
    }
    public void setReseñas(ArrayList<Reseña> reseñas) {
        if (reseñas == null) throw new IllegalArgumentException("La lista de reseñas no puede ser nula");
        this.reseñas = new ArrayList<>(reseñas);
    }
    public int getID() {
        return id;
    }

    /* Constructor */
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.reseñas = new ArrayList<>();
    }

    public void agregarReseña(Reseña reseña) {
        reseña.setAutor(this); // Relaciona la reseña con el usuario actual
        reseñas.add(reseña);
    }

    // El método mostrarReseñas debe estar en la capa de presentación/UI
}
