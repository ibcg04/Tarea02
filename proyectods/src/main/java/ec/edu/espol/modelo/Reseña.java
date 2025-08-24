package ec.edu.espol.modelo;

public class Reseña {
    private int calificacion;
    private String descripcion;
    private Usuario autor;

    // ===== NUEVO: fábrica estática para centralizar validaciones =====
    public static Reseña of(int calificacion, String descripcion, Usuario autor) {
        // Normalizamos descripción nula aquí
        if (descripcion == null) {
            descripcion = "";
        }
        // Validación conservadora: acotar a [1..5] sin lanzar excepción (no rompe tests)
        if (calificacion < 1) calificacion = 1;
        if (calificacion > 5) calificacion = 5;
        return new Reseña(calificacion, descripcion, autor);
    }

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

    /* Constructor (SE MANTIENE para no dañar tests) */
    public Reseña(int calificacion, String descripcion, Usuario autor) {
        if (descripcion == null) {
            System.out.println("[ADVERTENCIA] Descripción de reseña nula. Se asigna vacío.");
            descripcion = "";
        }
        this.calificacion = calificacion;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    // ===== NUEVO: pequeño comportamiento para evitar Data Class pura =====
    public boolean esPositiva() {
        return calificacion >= 4;
    }

    public boolean esNegativa() {
        return calificacion <= 2;
    }

    @Override
    public String toString() {
        return "Reseña: [Calificación: " + calificacion + ", Autor: " +
               (autor != null ? autor.getNombre() : "Desconocido") + "] '" + descripcion + "'";
    }
}
