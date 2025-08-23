package ec.edu.espol.modelo;


public class Restriccion extends Regla{
    private String restriccion;

    public Restriccion( String restriccion) {
        super("Restriccion de Alojamiento");
        this.restriccion = restriccion;
        
    }

    @Override
    public String toString() {
    return "Restricción: " + restriccion;
    }

    
}
