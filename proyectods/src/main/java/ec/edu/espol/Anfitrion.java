package ec.edu.espol;

import java.util.ArrayList;

public class Anfitrion extends Usuario implements ResuelveReporte{
    private ArrayList<Propiedad> propiedades;

    public Regla establecerregla(){
        return new Regla();
    }

    public Reseña reseñar(){
        return new Reseña();
    }

    @Override
    public void resolverReporte(Reporte r) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
   
    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }


}