package modelo;

import java.util.ArrayList;

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

    public Regla establecerregla(){
        return new Regla();
    }

    public Reseña reseñar(int calificacion, String descripcion){
        return new Reseña(calificacion, descripcion, this);
    }

    @Override
    public void resolverReporte(Reporte r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   


}