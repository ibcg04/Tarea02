package modelo;

public class Unidad {
    private double precio;
    private EstadoAlojamiento estado;
    private Huesped ocupante;

    public void setEstadoAlojamiento(EstadoAlojamiento estado) {
        this.estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public EstadoAlojamiento getEstadoAlojamiento() {
        return estado;
    }

    @Override
    public String toString() {
        return "Unidad{" + "precio=" + precio + ", estado=" + estado + ", ocupante=" + ocupante + '}';
    }   
    public void reservarUnidad(Huesped huesped) {
        if (estado == EstadoAlojamiento.DISPONIBLE) {
            estado = EstadoAlojamiento.RESERVADA;
            ocupante = huesped;
            System.out.println("Unidad reservada exitosamente por " + huesped.getNombre());
        } else {
            System.out.println("La unidad no está disponible.");
        }
    }

    public void liberarUnidad() {
        estado = EstadoAlojamiento.DISPONIBLE;
        ocupante = null;
        System.out.println("Unidad liberada.");
    }
}
