package ec.edu.espol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializar base de datos
        DataBase db = DataBase.getDataBase();

        // Crear anfitrión y asignar nombre
        Anfitrion anfitrion = new Anfitrion("Carlos", new ArrayList<>());
        
        // Crear propiedad y asignar ubicación
        Propiedad propiedad = new Propiedad();
        // Usamos reflexión para setear la ubicación y listas, ya que no hay setters públicos
        try {
            var fieldUbicacion = Propiedad.class.getDeclaredField("ubicacion");
            fieldUbicacion.setAccessible(true);
            fieldUbicacion.set(propiedad, "Guayaquil");

            var fieldUnidades = Propiedad.class.getDeclaredField("unidades");
            fieldUnidades.setAccessible(true);
            ArrayList<Unidad> unidades = new ArrayList<>();
            Unidad unidad = new Casa();
            // Seteamos precio y estado
            var fieldPrecio = Unidad.class.getDeclaredField("precio");
            fieldPrecio.setAccessible(true);
            fieldPrecio.set(unidad, 120.0);
            unidad.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);
            unidades.add(unidad);
            fieldUnidades.set(propiedad, unidades);

            var fieldResenias = Propiedad.class.getDeclaredField("reseñas");
            fieldResenias.setAccessible(true);
            ArrayList<Reseña> resenias = new ArrayList<>();
            Reseña resenia = new Reseña(5, "Excelente lugar", anfitrion);
            resenias.add(resenia);
            fieldResenias.set(propiedad, resenias);

            var fieldPropietario = Propiedad.class.getDeclaredField("propietario");
            fieldPropietario.setAccessible(true);
            fieldPropietario.set(propiedad, anfitrion);

            // Asignar propiedad al anfitrión
            var fieldPropiedades = Anfitrion.class.getDeclaredField("propiedades");
            fieldPropiedades.setAccessible(true);
            ArrayList<Propiedad> propiedadesAnfitrion = new ArrayList<>();
            propiedadesAnfitrion.add(propiedad);
            fieldPropiedades.set(anfitrion, propiedadesAnfitrion);

        } catch (Exception e) {
            System.out.println("Error inicializando propiedad: " + e.getMessage());
            return;
        }

        // Agregar anfitrión a la base de datos
        db.getAnfitriones().add(anfitrion);

        // Crear huésped y asignar nombre
        Huesped huesped = new Huesped("Ana", new ArrayList<>());

        // Simular búsqueda de propiedades
        System.out.println("Simulación: Huésped busca propiedades en Guayaquil con calificación mínima 3.");
        ArrayList<Propiedad> encontradas = huesped.buscarPropiedades("Guayaquil", 3);

        // Simular reserva si hay propiedades encontradas
        if (!encontradas.isEmpty()) {
            Propiedad prop = encontradas.get(0);
            Unidad unidadReservar = prop.getUnidades().get(0);
            System.out.println("Simulación: Huésped reserva una unidad.");
            huesped.reservar(unidadReservar);
        } else {
            System.out.println("No hay unidades disponibles para reservar.");
        }

        // Simular reseña
        System.out.println("Simulación: Huésped deja una reseña.");
        huesped.reseñar(4, "Muy buena experiencia");

        // Mostrar resumen
        System.out.println("Simulación completada.");
    }
}