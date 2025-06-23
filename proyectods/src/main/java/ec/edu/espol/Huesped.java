package ec.edu.espol;

import java.util.ArrayList;

public class Huesped extends Usuario {
    private Unidad unidadOcupada;

    public ArrayList<Propiedad> buscarPropiedades(String ubicacion, int calificacion){
        //Busca propiedades en la ubicación y con la reseña.
        ArrayList<Propiedad> propiedades_nuevas = new ArrayList<>();
        System.out.println("Buscando propiedades.....");
        for(Anfitrion a: DataBase.getDataBase().getAnfitriones()){
            for(Propiedad p: a.getPropiedades()){
                if(p.getUbicacion().equals(ubicacion)){
                    for(Reseña r: p.getReseñas()){
                        if(r.getCalificacion() >= calificacion) 
                            propiedades_nuevas.add(p);
                    }
                   
                }   
        }
        mostrarPropiedades(propiedades_nuevas); 
        }
        return propiedades_nuevas;
    }

      public Reseña reseñar(){
        return new Reseña();
    }

     public void mostrarPropiedades(ArrayList<Propiedad> propiedades){
        System.out.println("Propiedades disponibles:");
        
        //for(Propiedad p: propiedades){
        //    System.out.println(p);
        //}
    }

}
