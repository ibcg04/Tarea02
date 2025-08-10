package logica;

import java.util.Scanner;

import modelo.Anfitrion;
import modelo.Huesped;
import modelo.Moderador;
import modelo.Propiedad;
import modelo.Reporte;
import modelo.SoporteLegal;

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
        if (anfitrion.getReportes().isEmpty()) {
            System.out.println("No hay reportes pendientes.");
            return;
        }
        while (!anfitrion.getReportes().isEmpty()){
            Reporte reporte= anfitrion.getReportes().poll();
            System.out.println("\nProcesando reporte: " + reporte.getMensaje());

            Moderador moderador = new Moderador();
            SoporteLegal legal = new SoporteLegal();
            anfitrion.setNextHandler(moderador);
            moderador.setNextHandler(legal);

            anfitrion.resolverReporte(reporte);
            if (reporte.isResuelto()) {
            System.out.println("Reporte resuelto ");
        } else {
            System.out.println("Reporte no pudo ser resuelto ");
        }
    }
        }

    public static void generarReseña(Anfitrion anfitrion, Scanner sc) {
        int opcionHuesped = -1;
        while (true) {
        anfitrion.mostrarHistorialOcupantes();
        if (anfitrion.getHistorialOcupantes().isEmpty()) {
            System.out.println("No hay Huespedes para reseñar.");
            return;
        }
        System.out.print("Seleccione un Huesped para Reseñar: (1 a " + anfitrion.getHistorialOcupantes().size() + "): ");
        if (sc.hasNextInt()) {
            opcionHuesped = sc.nextInt();
            sc.nextLine();
            
            if (opcionHuesped >= 1 && opcionHuesped <= anfitrion.getHistorialOcupantes().size()) {
                break; // entrada válida, salir del bucle
            } else {
                System.out.println("Número fuera de rango. Intente nuevamente.");
            }
            
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // limpiar entrada inválida
        }
        Huesped huespedReseñar = anfitrion.getHistorialOcupantes().get(opcionHuesped - 1);
        System.out.println("Haciendo reseña...");
        System.out.print("Ingrese la calificación (1-5): ");
        int calificacion = -1;
        while (true) {
            if (sc.hasNextInt()) {
                calificacion = sc.nextInt();
                sc.nextLine();

                if (calificacion >= 1 && calificacion <= 5) {
                    break; // entrada válida, salir del bucle
                } else {
                    System.out.println("Número fuera de rango de calificacion. Intente nuevamente.");
                }
            }    
             else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine(); // limpiar entrada inválida
            }
        } 
        System.out.print("Ingrese la descripción de la reseña: ");
        String descripcion = sc.nextLine();
        
        anfitrion.reseñar(calificacion, descripcion, huespedReseñar);
        System.out.println("Reseña agregada exitosamente.");
    }
}
}