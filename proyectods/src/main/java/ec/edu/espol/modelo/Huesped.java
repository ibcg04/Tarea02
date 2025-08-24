package ec.edu.espol.modelo;


import java.util.ArrayList;

public class Huesped extends Usuario {
    // Hide Delegate para acceso a anfitriones
    protected java.util.Collection<Anfitrion> getAnfitriones() {
        return BaseDatos.getDataBase().getAnfitriones().values();
    }
    // Hide Delegate para reportar
    private Anfitrion getAnfitrionParaReporte() {
        if (unidadOcupada != null && unidadOcupada.getPropiedad() != null) {
            return unidadOcupada.getPropiedad().getPropietario();
        }
        return null;
    }
    public ArrayList<Propiedad> getPropiedadesDeUnidadOcupada() {
        if (unidadOcupada != null && unidadOcupada.getPropiedad() != null) {
            ArrayList<Propiedad> props = new ArrayList<>();
            props.add(unidadOcupada.getPropiedad());
            return props;
        }
        return new ArrayList<>();
    }

    public Anfitrion getAnfitrionDeUnidadOcupada() {
        if (unidadOcupada != null && unidadOcupada.getPropiedad() != null) {
            return unidadOcupada.getPropiedad().getPropietario();
        }
        return null;
    }

    public void agregarAHistorialOcupantesDeAnfitrion() {
        Anfitrion anfitrion = getAnfitrionDeUnidadOcupada();
        if (anfitrion != null && anfitrion.getHistorialOcupantes() != null) {
            anfitrion.getHistorialOcupantes().add(this);
        }
    }
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

    public ArrayList<Unidad> getHistorialReservas() {
        return historialReservas;
    }

    /* Constructor */
    public Huesped(String nombre, int id) {
        super(nombre, id);
        this.historialReservas = new ArrayList<>();
    }

    public void pagar(double precio) {
        System.out.println("Pago realizado");
        
    }


    public void reservar(Unidad unidad) {
        if (unidad == null) {
            System.out.println("[ADVERTENCIA] Unidad nula. No se puede reservar.");
            return;
        }
        if (unidad.getEstadoAlojamiento() == EstadoAlojamiento.DISPONIBLE) {
            setUnidadOcupada(unidad);
            unidad.setOcupante(this);
            unidad.setEstadoAlojamiento(EstadoAlojamiento.RESERVADA);
            pagar(unidad.getPrecio());
            historialReservas.add(unidad);
            agregarAHistorialOcupantesDeAnfitrion();
            System.out.println("Reserva exitosa");
        } else {
            System.out.println("La unidad no está disponible para reservar.");
        }
    }

    public Reseña reseñar(int calificacion, String descripcion){
        if (descripcion == null) {
            System.out.println("[ADVERTENCIA] Descripción de reseña nula. Se retorna reseña vacía.");
            return new Reseña(calificacion, "", this);
        }
        return new Reseña(calificacion, descripcion, this);
    }

   public Reseña reseñar(int calificacion, String descripcion, Usuario autor){
    return Reseña.of(calificacion, descripcion, autor);
}

    public void reportar(String mensaje){
        if (mensaje == null) {
            System.out.println("[ADVERTENCIA] Mensaje nulo. No se puede reportar.");
            return;
        }
        Anfitrion anfitrion = getAnfitrionParaReporte();
        if (anfitrion == null) {
            System.out.println("No hay una unidad/propiedad/anfitrión asociado para reportar.");
            return;
        }
        Reporte reporte = new Reporte(this, mensaje);
        System.out.println("Reportando incidente...");
        anfitrion.resolverReporte(reporte);
        System.out.println("Reporte enviado a la cola de incidentes del anfitrión.");
    }
    public void mostrarPropiedades(ArrayList<Propiedad> propiedades){
        System.out.println("Propiedades disponibles:");
        
        for(Propiedad p: propiedades){
            System.out.println(p);
        }
    }

    public ArrayList<Propiedad> buscarPropiedades(String ubicacion, int calificacion){
        // Refactor: delega la búsqueda a Anfitrion para evitar feature envy y long method
        ArrayList<Propiedad> propiedades_nuevas = new ArrayList<>();
        System.out.println("Buscando propiedades...");
        for (Anfitrion a : getAnfitriones()) {
            propiedades_nuevas.addAll(a.buscarPropiedadesPorUbicacionYCalificacion(ubicacion, calificacion));
        }
        mostrarPropiedades(propiedades_nuevas);
        return propiedades_nuevas;
    }

    @Override
    public String toString() {
    return "Huésped: " + getNombre() + " (ID: " + getID() + ")";
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
