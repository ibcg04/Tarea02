package modelo;

public class Reporte {
    private Huesped autor;
    private String mensaje;
    private boolean resuelto;

    public Huesped getAutor(){
        return autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Reporte(Huesped autor, String mensaje) {
        this.autor = autor;
        this.mensaje = mensaje;
    }

    public void setResuelto(boolean b) {
        this.resuelto = b;
    }

    public boolean isResuelto() { 
        return resuelto;
     }
}
