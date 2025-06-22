package ec.edu.espol;

public class Unidad {
    private double precio;
    private EstadoAlojamiento estado;
    private Huesped ocupante;

    @Override
    public String toString() {
        return "Unidad{" + "precio=" + precio + ", estado=" + estado + ", ocupante=" + ocupante + '}';
    }   
}
