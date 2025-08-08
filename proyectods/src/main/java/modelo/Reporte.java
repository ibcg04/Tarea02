package modelo;

public class Reporte {
    private Huesped autor;
    private String mensaje;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setResuelto'");
    }
}
