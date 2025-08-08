package logica;

import java.util.Scanner;

import modelo.Anfitrion;
import modelo.Propiedad;

public class AnfitrionManager {
    
    public static void manejarPropiedades(Anfitrion anfitrion, Scanner sc) {
        if (anfitrion.getPropiedades().isEmpty()) {
            System.out.println("No tienes propiedades registradas.");
            return;
        }
        int opcionPropiedad = -1;
        while (true) {
        System.out.print("Ingrese el número de la propiedad (1 a " + anfitrion.getPropiedades().size() + "): ");
        
        if (sc.hasNextInt()) {
            opcionPropiedad = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            
            if (opcionPropiedad >= 1 && opcionPropiedad <= anfitrion.getPropiedades().size()) {
                break; // entrada válida, salir del bucle
            } else {
                System.out.println("Número fuera de rango. Intente nuevamente.");
            }
            
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // limpiar entrada inválida
        }
        
        }
        Propiedad propiedadSeleccionada = anfitrion.getPropiedades().get(opcionPropiedad - 1);

        while(true){
        System.out.println("Seleccione una que desea hacer con la propiedad seleccionada:");
        System.out.println("1. Agregar propiedad");
        System.out.println("2. Eliminar propiedad");
        System.err.println("3. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        
        switch (opcion) {
            case 1:
                anfitrion.agregarPropiedad(propiedadSeleccionada);
                System.out.println("Propiedad agregada exitosamente.");
                break;
            case 2:
                anfitrion.eliminarPropiedad(propiedadSeleccionada);
                System.out.println("Propiedad eliminada exitosamente.");
                break;
            case 3:
                System.out.println("Saliendo del manejo de propiedades...");
                return;
            default:
                System.out.println("Opción no válida, intentelo de nuevo.");
                break;
        }
    }
        
}
    public static void manejarIncidentes(Anfitrion anfitrion, Scanner sc) {
        System.out.println("Manejando incidentes...");
        // Aquí se puede implementar la lógica para manejar incidentes
        // Por ejemplo, mostrar reportes, resolverlos, etc.
    }

    public static void generarReseña(Anfitrion anfitrion, Scanner sc, Propiedad propiedad) {
        int opcionHuesped = -1;
        while (true) {
        System.out.print("Ingrese el ID del huesped. (1 a " + propiedad.getUnidades() + "): ");
        
        if (sc.hasNextInt()) {
            opcionHuesped = sc.nextInt();
            sc.nextLine(); // limpiar buffer
            
            if (opcionHuesped >= 1 && opcionHuesped <= anfitrion.getPropiedades().size()) {
                break; // entrada válida, salir del bucle
            } else {
                System.out.println("Número fuera de rango. Intente nuevamente.");
            }
            
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // limpiar entrada inválida
        }
        System.out.println("Haciendo reseña...");
        System.out.print("Ingrese la calificación (1-5): ");
        int calificacion = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Ingrese la descripción de la reseña: ");
        String descripcion = sc.nextLine();
        
        if (calificacion < 1 || calificacion > 5) {
            System.out.println("Calificación inválida. Debe ser entre 1 y 5.");
            return;
        }
        
        anfitrion.reseñar(calificacion, descripcion);
        System.out.println("Reseña agregada exitosamente.");
    }
}