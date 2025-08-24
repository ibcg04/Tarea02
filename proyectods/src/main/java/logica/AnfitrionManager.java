package logica;


import java.util.Scanner;

import modelo.Anfitrion;
import modelo.Huesped;
import modelo.Moderador;
import modelo.Propiedad;
import modelo.Reporte;
import modelo.SoporteLegal;
import utilidades.EntradaUtils;

public class AnfitrionManager {
    
    public static void manejarPropiedades(Anfitrion anfitrion, Scanner sc) {
        if (anfitrion.getPropiedades().isEmpty()) {
            System.out.println("No tienes propiedades registradas.");
            return;
        }

        Propiedad propiedadSeleccionada = seleccionarPropiedad(anfitrion, sc);

        manejarAccionesPropiedad(anfitrion, propiedadSeleccionada, sc);
    }

    private static Propiedad seleccionarPropiedad(Anfitrion anfitrion, Scanner sc) {
        int opcionPropiedad = EntradaUtils.validarEntradaEntero(
            sc,
            "Ingrese el número de la propiedad (1 a " + anfitrion.getPropiedades().size() + "): ",
            1,
            anfitrion.getPropiedades().size()
        );
        return anfitrion.getPropiedades().get(opcionPropiedad - 1);
    }

    private static void manejarAccionesPropiedad(Anfitrion anfitrion, Propiedad propiedadSeleccionada, Scanner sc) {
        while (true) {
            System.out.println("Seleccione una acción para la propiedad seleccionada:");
            System.out.println("1. Agregar propiedad");
            System.out.println("2. Eliminar propiedad");
            System.out.println("3. Salir");

            int opcion = EntradaUtils.validarEntradaEntero(
                sc,
                "Ingrese una opción: ",
                1,
                3
            );

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
        anfitrion.mostrarHistorialOcupantes();
        if (anfitrion.getHistorialOcupantes().isEmpty()) {
            System.out.println("No hay Huespedes para reseñar.");
            return;
        }

        Huesped huespedReseñar = seleccionarHuesped(anfitrion, sc);

        System.out.println("Haciendo reseña...");
        int calificacion = solicitarCalificacion(sc);

        String descripcion = solicitarDescripcion(sc);

        anfitrion.reseñar(calificacion, descripcion, huespedReseñar);
        System.out.println("Reseña agregada exitosamente.");
    }
     private static Huesped seleccionarHuesped(Anfitrion anfitrion, Scanner sc) {
        int opcionHuesped = EntradaUtils.validarEntradaEntero(
            sc,
            "Seleccione un Huesped para Reseñar: (1 a " + anfitrion.getHistorialOcupantes().size() + "): ",
            1,
            anfitrion.getHistorialOcupantes().size()
        );
        return anfitrion.getHistorialOcupantes().get(opcionHuesped - 1);
    }

    private static int solicitarCalificacion(Scanner sc) {
        return EntradaUtils.validarEntradaEntero(
            sc,
            "Ingrese la calificación (1-5): ",
            1,
            5
        );
    }
       private static String solicitarDescripcion(Scanner sc) {
        System.out.print("Ingrese la descripción de la reseña: ");
        return sc.nextLine();
    }
}