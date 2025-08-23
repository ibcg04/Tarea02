package ec.edu.espol.modelo;

public class Unidad {
    private double precio;
    private EstadoAlojamiento estado;
    private Huesped ocupante;
    private Propiedad propiedad;
 
    //GETTERS Y SETTERS
    public Propiedad getPropiedad() {
        return propiedad;
    }
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }
    public void setEstadoAlojamiento(EstadoAlojamiento estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public EstadoAlojamiento getEstadoAlojamiento() {
        return estado;
    }
    //
    @Override
    public String toString() {
    return "Unidad: precio $" + precio + ", estado: " + estado + ", ocupante: " + (ocupante != null ? ocupante.getNombre() : "Ninguno");
    }   
    
    public void liberarUnidad() {
        estado = EstadoAlojamiento.DISPONIBLE;
        ocupante = null;
        System.out.println("Unidad liberada.");
    }
    // Agrega después de los métodos existentes

    public Huesped getOcupante() {
        return ocupante;
    }

    public void setOcupante(Huesped ocupante) {
        this.ocupante = ocupante;
    }

    public boolean estaDisponible() {
        return estado == EstadoAlojamiento.DISPONIBLE;
    }

    public void mostrarDetalles() {
        System.out.println("Detalles de la unidad:");
        System.out.println("Precio: $" + precio);
        System.out.println("Estado: " + estado);
        System.out.println("Ocupante: " + (ocupante != null ? ocupante.getNombre() : "Ninguno"));
    }
    public void marcarEnMantenimiento() {
        estado = EstadoAlojamiento.EN_MANTENIMIENTO;
        System.out.println("Unidad marcada en mantenimiento.");
    }

    public void marcarFueraDeServicio() {
        estado = EstadoAlojamiento.FUERA_DE_SERVICIO;
        System.out.println("Unidad marcada fuera de servicio.");
    }
    
    
}
