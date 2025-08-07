package modelo;

import java.util.Date;

public class CheckInCheckOut extends Regla {
    private Date horarioCheckIn;
    private Date horarioCheckOut;
    public CheckInCheckOut( Date horarioCheckIn, Date horarioCheckOut) {
        super("Horario CheckIn y CheckOut");
        this.horarioCheckIn = horarioCheckIn;
        this.horarioCheckOut = horarioCheckOut;
    }

    
}
