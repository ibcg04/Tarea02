package modelo;

import java.util.ArrayList;
import modelo.BaseDatos;

public class Huesped extends Usuario {
    private Unidad unidadOcupada;
/* 
    public Huesped(String nombre) {
        super(nombre);
    }
*/

    public void Reportar(String mensaje){

        System.out.println("Reporte enviado");
        
    }   

    /* Getters y Setters */
    public void setUnidadOcupada(Unidad unidadOcupada) {
        this.unidadOcupada = unidadOcupada;
    }
    public Unidad getUnidadOcupada() {
        return unidadOcupada;
    }   
    public int getID() {
        return super.getID();
    }

    /* Constructor */
    public Huesped(String nombre, int id) {
        super(nombre, id);
    }

    public void pagar(double precio) {
        System.out.println("Pago realizado");
    }


    public void reservar(Unidad unidad) {
        if (unidad.getEstadoAlojamiento() == EstadoAlojamiento.DISPONIBLE) {
            setUnidadOcupada(unidad);
            unidad.setEstadoAlojamiento(EstadoAlojamiento.RESERVADA);
            pagar(unidad.getPrecio());
            System.out.println("Reserva exitosa");
        } else {
            System.out.println("La unidad no está disponible para reservar.");
        }
    }

    public Reseña reseñar(int calificacion, String descripcion){
        return new Reseña(calificacion, descripcion, this);
    }

    public Reporte reportar(Huesped autor, String mensaje){
        return new Reporte(autor, mensaje);
    }
    public void mostrarPropiedades(ArrayList<Propiedad> propiedades){
        System.out.println("Propiedades disponibles:");
        
        for(Propiedad p: propiedades){
            System.out.println(p);
        }
    }

    public ArrayList<Propiedad> buscarPropiedades(String ubicacion, int calificacion){
        //Busca propiedades en la ubicación y con la reseña.
        ArrayList<Propiedad> propiedades_nuevas = new ArrayList<>();
        System.out.println("Buscando propiedades...");
        for(Anfitrion a: BaseDatos.getDataBase().getAnfitriones().values()){
            for(Propiedad p: a.getPropiedades()){
                if(p.getUbicacion().equals(ubicacion)){
                    for(Reseña r: p.getReseñas()){
                        if(r.getCalificacion() >= calificacion) 
                            propiedades_nuevas.add(p);
                    }
                   
                }   
            }
        }
        mostrarPropiedades(propiedades_nuevas); 
        return propiedades_nuevas;

        }

    @Override
    public String toString() {
        return "Huesped " + getNombre() + ", getID()=" + getID()
                + "]";
    }
    }
