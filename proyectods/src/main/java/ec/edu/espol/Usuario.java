package ec.edu.espol;

import java.util.ArrayList;

public class Usuario {
    public Usuario(String nombre) {
        this.nombre = nombre;
        this.reseñas = new ArrayList<>();
    }
    private String nombre;
    private ArrayList<Reseña> reseñas;
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
    
}
