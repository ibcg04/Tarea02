package modelo;


import java.util.ArrayList;

public class Huesped extends Usuario {
    private Unidad unidadOcupada;
    private ArrayList<Unidad> historialReservas;
 
    /* Getters y Setters */
    public void setUnidadOcupada(Unidad unidadOcupada) {
        this.unidadOcupada = unidadOcupada;
    }
    public Unidad getUnidadOcupada() {
        return unidadOcupada;
    }   
    @Override
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
            historialReservas.add(unidad);
            unidadOcupada.getPropiedad().getPropietario().getHistorialOcupantes().add(this);
        } else {
            System.out.println("La unidad no está disponible para reservar.");
        }
    }

    public Reseña reseñar(int calificacion, String descripcion){
        return new Reseña(calificacion, descripcion, this);
    }

    public Reseña reseñar(int calificacion, String descripcion, Usuario autor){
        return new Reseña(calificacion, descripcion, autor);
    }

    public void reportar(String mensaje){
        if (unidadOcupada == null || unidadOcupada.getPropiedad() == null
                || unidadOcupada.getPropiedad().getPropietario() == null) {
            System.out.println("No hay una unidad/propiedad/anfitrión asociado para reportar.");
            return; 
        }
        Reporte reporte = new Reporte(this, mensaje);

        //Construir la cadena
        Anfitrion anfitrion = unidadOcupada.getPropiedad().getPropietario();
        Moderador moderador = new Moderador();
        SoporteLegal legal = new SoporteLegal();

        // encadenar
        anfitrion.setNextHandler(moderador);
        moderador.setNextHandler(legal);

        // disparar la cadena desde el anfitrión
        System.out.println("Reportando incidente...");
        anfitrion.resolverReporte(reporte);

        // confirmar resultado al usuario
        if (reporte.isResuelto()) {
            System.out.println("Incidente resuelto.");
        } else {
            System.out.println("Incidente no pudo ser resuelto.");
        }
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

    public void cancelarReserva() {
        if (unidadOcupada != null) {
            unidadOcupada.liberarUnidad();
            unidadOcupada = null;
            System.out.println("Reserva cancelada exitosamente.");
        } else {
            System.out.println("No tienes ninguna reserva activa.");
        }
    }

    public void verReservaActual() {
        if (unidadOcupada != null) {
            System.out.println("Tu reserva actual:");
            unidadOcupada.mostrarDetalles();
        } else {
            System.out.println("No tienes ninguna reserva activa.");
        }
    }

    public void mostrarReservas() {
        if (historialReservas == null || historialReservas.isEmpty()) {
            System.out.println("No tienes reservas en tu historial.");
        } else {
            System.out.println("Historial de reservas:");
            for (Unidad u : historialReservas) {
                u.mostrarDetalles();
            }
        }
    }



}
