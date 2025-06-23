package ec.edu.espol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Crear anfitrión y su propiedad
        Anfitrion anfitrion = new Anfitrion("Carlos");
        Casa casa = new Casa();
        casa.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);

        ArrayList<Unidad> unidades = new ArrayList<>();
        unidades.add(casa);

        Reseña resenia = new Reseña(5, "Excelente lugar", anfitrion);
        ArrayList<Reseña> resenias = new ArrayList<>();
        resenias.add(resenia);

        Propiedad propiedad = new Propiedad("Guayaquil", unidades, anfitrion, resenias);

        ArrayList<Propiedad> propiedadesAnfitrion = new ArrayList<>();
        propiedadesAnfitrion.add(propiedad);

        // Asignar propiedades al anfitrión (por defecto el atributo es privado, pero puedes agregar un setter)
        // anfitrion.setPropiedades(propiedadesAnfitrion);

        // 2. Agregar anfitrión a la base de datos
        DataBase.getDataBase().getAnfitriones().add(anfitrion);

        // 3. Crear huésped
        Huesped huesped = new Huesped("Ana");

        // 4. El huésped busca propiedades
        System.out.println("=== Búsqueda de propiedades ===");
        ArrayList<Propiedad> encontradas = huesped.buscarPropiedades("Guayaquil", 4);

        // 5. El huésped reserva la primera unidad disponible
        if (!encontradas.isEmpty()) {
            Propiedad prop = encontradas.get(0);
            Unidad unidad = prop.getUnidades().get(0);
            System.out.println("=== Reserva de unidad ===");
            huesped.reservar(unidad);
        } else {
            System.out.println("No se encontraron propiedades disponibles para reservar.");
        }

        // 6. El huésped deja una reseña
        System.out.println("=== Reseña del huésped ===");
        huesped.reseñar(4, "Muy buena experiencia");

        // 7. El huésped reporta un incidente
        System.out.println("=== Reporte de incidente ===");
        huesped.Reportar("La casa tenía un problema menor.");

        // 8. Moderador resuelve el reporte
        Moderador moderador = new Moderador();
        Reporte reporte = new Reporte(huesped, "La casa tenía un problema menor.");
        moderador.resolverReporte(reporte);

        System.out.println("=== Fin de la simulación ===");
    }
}