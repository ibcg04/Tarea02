package modelo;

public class Moderador implements ResuelveReporte{
    @Override
    public void resolverReporte(Reporte r) {
        System.out.println("Incidente resuelto");
    }
}
