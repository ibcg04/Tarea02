package modelo;

public class Moderador implements ResuelveReporte{
    //siguiente handler:
    private ResuelveReporte nextHandler;
    
    public void setNextHandler(ResuelveReporte nextHandler) {
        this.nextHandler = nextHandler;
    } 
    @Override
    public void resolverReporte(Reporte r) {
        if (nextHandler != null) {
            System.out.println("Moderador revisa y delega a Soporte Legal...");
            nextHandler.resolverReporte(r);
        } else {
            System.out.println("Moderador resuelve el incidente.");
            r.setResuelto(true);
        }
    } 
}
