package ec.edu.espol;
import java.util.Date;

public class Regla {
    Date horarioCheckIn;
    Date horarioCheckOut;
    String restricciones;
    public Regla(Date horarioCheckIn, Date horarioCheckOut, String restricciones) {
        this.horarioCheckIn = horarioCheckIn;
        this.horarioCheckOut = horarioCheckOut;
        this.restricciones = restricciones;
    }
    
}
