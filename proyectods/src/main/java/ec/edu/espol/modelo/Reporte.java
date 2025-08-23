package ec.edu.espol.modelo;

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
        if (mensaje == null) {
            System.out.println("[ADVERTENCIA] mensaje no puede ser null, se asigna vacío.");
            this.mensaje = "";
        } else {
            this.mensaje = mensaje;
        }
    }

    public void setResuelto(boolean b) {
        this.resuelto = b;
    }

    public boolean isResuelto() { 
        return resuelto;
     }
}
