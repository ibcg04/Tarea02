package ec.edu.espol.modelo;

// ...existing code...
import java.util.ArrayList;

public class ListadoReglas {
    private ArrayList<Regla> listReglas;

    public ListadoReglas() {
        listReglas = new ArrayList<>();
    }

    public void agregarRegla(Regla regla) {
        listReglas.add(regla);
    }

    public void mostrarReglas() {
        if (listReglas.isEmpty()) {
            System.out.println("No hay reglas registradas.");
        } else {
            System.out.println("Reglas:");
            for (Regla r : listReglas) {
                System.out.println("- " + r.descripcion);
            }
        }
    }
}