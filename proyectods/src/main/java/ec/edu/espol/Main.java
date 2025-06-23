package ec.edu.espol;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DataBase db = DataBase.getDataBase();

        // Crear anfitrión y propiedad
        Anfitrion anfitrion = new Anfitrion();
        Propiedad propiedad = new Propiedad();
        // Suponiendo que Propiedad y Anfitrion tienen setters o constructores adecuados
        // Aquí solo se agregan referencias simples para la simulación
        ArrayList<Propiedad> propiedadesAnfitrion = new ArrayList<>();
        propiedadesAnfitrion.add(propiedad);
        // Simular que el anfitrión tiene propiedades
        // Esto requiere que el atributo 'propiedades' de Anfitrion no sea null
        // Si es null, inicialízalo en el constructor de Anfitrion

        // Agregar anfitrión a la base de datos
        db.getAnfitriones().add(anfitrion);

        // Crear huésped
        Huesped huesped = new Huesped();

        // Simular búsqueda de propiedades
        System.out.println("Simulación: Huésped busca propiedades en una ubicación con calificación mínima.");
        huesped.buscarPropiedades("Guayaquil", 3);

        // Simular reserva (esto requiere que la propiedad tenga unidades disponibles)
        Unidad unidad = new Casa(); // o DepartamentoCompleto/HabitacionPrivada
        // Suponiendo que puedes setear el estado y precio
        unidad.setEstadoAlojamiento(EstadoAlojamiento.DISPONIBLE);
        // Aquí deberías tener un setter para el precio si quieres simular el pago
        // unidad.setPrecio(100.0); // Si tienes el método

        // Agregar unidad a la propiedad
        ArrayList<Unidad> unidades = new ArrayList<>();
        unidades.add(unidad);
        // Suponiendo que puedes setear las unidades en la propiedad
        // propiedad.setUnidades(unidades); // Si tienes el método

        // Simular reserva
        System.out.println("Simulación: Huésped reserva una unidad.");
        huesped.reservar(unidad);

        // Simular reseña
        System.out.println("Simulación: Huésped deja una reseña.");
        Reseña resena = huesped.reseñar();
        // Aquí podrías setear calificación y descripción si tienes setters

        // Mostrar resumen
        System.out.println("Simulación completada.");
    }
}