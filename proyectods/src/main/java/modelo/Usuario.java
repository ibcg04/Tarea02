package modelo;

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
        return reseñas;
    }
    public void setReseñas(ArrayList<Reseña> reseñas) {
        this.reseñas = reseñas;
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
}
