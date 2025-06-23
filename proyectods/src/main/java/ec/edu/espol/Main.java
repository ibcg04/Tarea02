package ec.edu.espol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Crear anfitrión
        Anfitrion anfitrion = new Anfitrion("Carlos", new ArrayList<>());

        // Crear unidad y setear estado y precio
        Casa casa = new Casa();
        // No hay setter para precio, pero puedes modificar Unidad para agregarlo si lo necesitas
        // casa.setPrecio(100.0); // Si agregas un setter en Unidad
        casa.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);

        ArrayList<Unidad> unidades = new ArrayList<>();
        unidades.add(casa);

        // Crear reseña
        Reseña resenia = new Reseña(5, "Excelente lugar", anfitrion);
        ArrayList<Reseña> resenias = new ArrayList<>();
        resenias.add(resenia);

        // Crear propiedad y asignar al anfitrión
        Propiedad propiedad = new Propiedad("Guayaquil", unidades, anfitrion, resenias);
        ArrayList<Propiedad> propiedadesAnfitrion = new ArrayList<>();
        propiedadesAnfitrion.add(propiedad);

        // Asignar propiedades al anfitrión usando reflexión o agregando un setter en Anfitrion
        // anfitrion.setPropiedades(propiedadesAnfitrion); // Si agregas un setter

        // Agregar anfitrión a la base de datos
        DataBase.getDataBase().getAnfitriones().add(anfitrion);

        // Crear huésped
        Huesped huesped = new Huesped("Ana", new ArrayList<>());

        // El huésped busca propiedades
        System.out.println("=== Búsqueda de propiedades ===");
        ArrayList<Propiedad> encontradas = huesped.buscarPropiedades("Guayaquil", 4);

        // El huésped reserva la primera unidad disponible
        if (!encontradas.isEmpty()) {
            Propiedad prop = encontradas.get(0);
            Unidad unidad = prop.getUnidades().get(0);
            System.out.println("=== Reserva de unidad ===");
            huesped.reservar(unidad);
        } else {
            System.out.println("No se encontraron propiedades disponibles para reservar.");
        }

        // El huésped deja una reseña
        System.out.println("=== Reseña del huésped ===");
        huesped.reseñar(4, "Muy buena experiencia");

        // El huésped reporta un incidente
        System.out.println("=== Reporte de incidente ===");
        huesped.Reportar("La casa tenía un problema menor.");

        // Moderador resuelve el reporte
        Moderador moderador = new Moderador();
        Reporte reporte = new Reporte(huesped, "La casa tenía un problema menor.");
        moderador.resolverReporte(reporte);

        System.out.println("=== Fin de la simulación ===");
    }
}