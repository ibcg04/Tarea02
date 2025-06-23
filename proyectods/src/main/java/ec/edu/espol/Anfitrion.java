package ec.edu.espol;

import java.util.ArrayList;
import java.util.Date;

public class Anfitrion extends Usuario implements ResuelveReporte{
    public Anfitrion(String nombre) {
        super(nombre);
    }

    private ArrayList<Propiedad> propiedades;

    public Regla establecerregla(Date chIn, Date chOut, String restricciones){
        return new Regla(chIn,chOut,restricciones);
    }

    public Reseña reseñar(int calificacion, String descripcion){
        Reseña resenia = new Reseña(calificacion, descripcion, this);
        this.getReseñas().add(resenia);
        return resenia;
    }

    @Override
    public void resolverReporte(Reporte r) {
        System.out.println("Incidente resuelto");
    }
   
    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }


}