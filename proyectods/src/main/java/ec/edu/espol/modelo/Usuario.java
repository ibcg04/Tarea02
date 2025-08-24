package ec.edu.espol.modelo;

import java.util.ArrayList;

public class Usuario {
    // Hide Delegate: Métodos para encapsular acceso a campos internos
    protected String obtenerNombre() {
        return getNombre();
    }

    protected int obtenerID() {
        return getID();
    }

    protected java.util.List<Reseña> obtenerReseñas() {
        return getReseñas();
    }
    private String nombre;
    private final int id;
    private ArrayList<Reseña> reseñas = new ArrayList<>();

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

    public void agregarReseña(Reseña reseña) {
        reseña.setAutor(this); // Relaciona la reseña con el usuario actual
        reseñas.add(reseña);
    }

    // El método mostrarReseñas debe estar en la capa de presentación/UI
}
