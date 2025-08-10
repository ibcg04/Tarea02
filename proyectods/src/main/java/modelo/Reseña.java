package modelo;

public class Reseña {
    private int calificacion;
    private String descripcion;
    private Usuario autor;

    /* Getters y Setters */
    public int getCalificacion() {
        return calificacion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public Usuario getAutor() {
        return autor;
    }
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /* Constructor */
    public Reseña(int calificacion, String descripcion, Usuario autor) {
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.autor = autor;
    }
    @Override
    public String toString() {
        return "Reseña [calificacion=" + calificacion + ", descripcion=" + descripcion + ", autor=" + autor + "]";
    }
    
    
}
