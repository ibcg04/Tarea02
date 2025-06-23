package ec.edu.espol;

public class Moderador implements ResuelveReporte{
    @Override
    public void resolverReporte(Reporte r) {
        System.out.println("Incidente resuelto");
    }
}
