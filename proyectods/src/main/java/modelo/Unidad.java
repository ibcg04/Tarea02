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
}
