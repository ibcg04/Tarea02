package ec.edu.espol;

import java.util.ArrayList;

public class Propiedad {
    private String ubicacion;
    private ArrayList<Unidad> unidades;
    private Anfitrion propietario;
    private ArrayList<Reseña> reseñas;

    public void mostrarUnidades(){
        for(Unidad u : unidades){
            System.out.println(u);
        }
        
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
        return "Propiedad{" + "Ubicacion=" + ubicacion + ", Unidades=" + unidades + ", Propietario=" + propietario + ", Reseñas=" + reseñas + '}';
    }   
}
