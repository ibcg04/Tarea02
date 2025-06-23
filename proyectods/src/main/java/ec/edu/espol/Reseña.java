package ec.edu.espol;

public class Reseña {
    private int calificacion;
    private String descripcion;
    private Usuario autor;

    

    public Reseña(int calificacion, String descripcion, Usuario autor) {
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getAutor() {
        return autor;
    }


    
}
