package modelo;
public class SoporteLegal implements ResuelveReporte {
    
    private ResuelveReporte nextHandler;
    
    public void setNextHandler(ResuelveReporte nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override
    public void resolverReporte(Reporte r) {
        System.out.println("Soporte Legal revisa y cierra el incidente.");
        r.setResuelto(true);
    } 
}
