package modelo;

public class Moderador implements ResuelveReporte{
    //siguiente handler:
    private ResuelveReporte nextHandler;
    
    public void setNextHandler(ResuelveReporte nextHandler) {
        this.nextHandler = nextHandler;
    } 
    @Override
    public void resolverReporte(Reporte r) {
        System.out.println("Moderador revisa el incidente...");
        if (!r.isResuelto() && this.nextHandler != null) {
            System.out.println("Moderador delega a Soporte Legal...");
            this.nextHandler.resolverReporte(r);
        } else if (!r.isResuelto()) {
            System.out.println("Moderador resuelve el incidente.");
            r.setResuelto(true);
        }
}
}
