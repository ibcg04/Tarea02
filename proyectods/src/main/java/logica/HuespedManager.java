package logica;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.espol.MenuHuesped;
import modelo.Anfitrion;
import modelo.BaseDatos;
import modelo.Huesped;
import modelo.Propiedad;
import modelo.Unidad;

public class HuespedManager {
        System.out.println("==========Buscar Propiedades==========");
        System.out.println("1. Buscar por ubicación");
        System.out.println("2. Buscar por precio");
        System.out.println("3. Buscar por tipo de propiedad");
        System.out.println("4. Buscar por servicios");
        System.out.println("5. Volver al menú principal");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Buscando por ubicación...");
                
                break;
            case 2:
                System.out.println("Buscando por precio...");
                break;
            case 3:
                System.out.println("Buscando por tipo de propiedad...");
                break;
            case 4:
                System.out.println("Buscando por servicios...");
                break;
            case 5:
                System.out.println("Volviendo al menú principal...");
                MenuHuesped.mostrarMenu(huesped,sc);
                break;
            default:
                break;
        }

    }
    
    public static ArrayList<Propiedad> mostrarPropiedades(Scanner sc){
        int enumeration = 1;
        ArrayList<Propiedad> propiedades = new ArrayList<>();
        for(Anfitrion a: BaseDatos.getDataBase().getAnfitriones().values()){
            for(Propiedad p: a.getPropiedades()){
                System.out.println(enumeration +".- "+p);
                propiedades.add(p);
                enumeration++;

            }
    }
    return propiedades;
}
    public static void reservarPropiedad(Huesped huesped, Scanner sc) {
    System.out.println("Reservando Propiedad...");
        System.out.println("Propiedades disponibles:");
        int opcionReserva = -1;

        while (true) {
        ArrayList<Propiedad> propiedadesReservar = HuespedManager.mostrarPropiedades(sc);
        System.out.print("Seleccione una Propiedad: (1 a " +  propiedadesReservar.size() + "): ");
        if (sc.hasNextInt()) {
            opcionReserva = sc.nextInt();
            sc.nextLine();
            
            if (opcionReserva >= 1 && opcionReserva <= propiedadesReservar.size()) {
                break; // entrada válida, salir del bucle
            } else {
                System.out.println("Número fuera de rango. Intente nuevamente.");
            }
            
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            sc.nextLine(); // limpiar entrada inválida
        }
        Propiedad propiedadSeleccionada = propiedadesReservar.get(opcionReserva - 1);
        propiedadSeleccionada.mostrarUnidades();
        System.out.print("Seleccione la Unidad que deseas RESERVAR : (1 a " +  propiedadSeleccionada.getUnidades().size() + "): ");
        int opcionUnidad = -1;  
        while (true) {
            if (sc.hasNextInt()) {
                opcionUnidad = sc.nextInt();
                sc.nextLine();
                
                if (opcionUnidad >= 1 && opcionUnidad <= propiedadSeleccionada.getUnidades().size()) {
                    break; // entrada válida, salir del bucle
                } else {
                    System.out.println("Número fuera de rango. Intente nuevamente.");
                }
                
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine(); // limpiar entrada inválida
            }
        }
        Unidad unidadSeleccionada = propiedadSeleccionada.getUnidades().get(opcionUnidad - 1);
        huesped.reservar(unidadSeleccionada);
        System.out.println("Reserva realizada con éxito.");
        

        }
    }
    public static void generarReseña(Huesped huesped, Scanner sc) {
        System.out.println("Generando reseña...");
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
        if (huesped.getUnidadOcupada() != null) {
            Anfitrion anfi =  huesped.getUnidadOcupada().getPropiedad().getPropietario();
            huesped.reseñar(calificacion, descripcion, anfi);
            System.out.println("Reseña generada exitosamente.");
        } else {
            System.out.println("No tienes una unidad ocupada para generar una reseña.");
        }
    }
}