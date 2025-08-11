package logica;

import java.util.ArrayList;
import java.util.Scanner;

import ec.edu.espol.MenuHuesped;
import modelo.Anfitrion;
import modelo.BaseDatos;
import modelo.Casa;
import modelo.DepartamentoCompleto;
import modelo.HabitacionPrivada;
import modelo.Huesped;
import modelo.Propiedad;
import modelo.Servicio;
import modelo.Unidad;

public class HuespedManager {
    public static void buscarPropiedades(Huesped huesped, Scanner sc) {
        System.out.println("==========Buscar Propiedades==========");
        System.out.println("1. Buscar por ubicación");
        System.out.println("2. Buscar por precio");
        System.out.println("3. Buscar por tipo de propiedad");
        System.out.println("4. Buscar por servicios");
        System.out.println("5. Volver al menú principal");

        
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Buscando por ubicación...");
                System.out.println("Ingrese la ubicación que desea buscar:");
                sc.nextLine(); // Limpiar el buffer
                String ubicacion = sc.nextLine();
                HuespedManager.buscarPorUbicacion(ubicacion, sc, huesped);
                break;
            case 2:
                System.out.println("Buscando por precio...");
                System.out.println("Ingrese el precio máximo: ");
                double precioMaximo = -1;                
                while (true) {
                System.out.println("Ingrese el valora maximo que desea buscar;");
                if (sc.hasNextDouble()) {
                    precioMaximo = sc.nextDouble();
                    sc.nextLine(); // limpiar buffer                   
                    if (precioMaximo >= 1) {
                        break; // entrada válida, salir del bucle
                    } else {
                        System.out.println("Número fuera de rango. Intente nuevamente.");
                    }                    
                } else {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    sc.nextLine(); // limpiar entrada inválida
                    }
                }
                HuespedManager.buscarPorPrecio(precioMaximo, sc, huesped);
                break;
            case 3:
                System.out.println("Buscando por tipo de propiedad...");
                System.out.println("Ingrese el tipo de propiedad que desea buscar(CASA, DEPARTAMENTO, HABITACION):");
                sc.nextLine(); // Limpiar el buffer
                String tipoPropiedad = sc.nextLine().trim().toUpperCase();
                 // Limpiar el buffer
                ArrayList<Propiedad> propiedades = HuespedManager.mostrarPropiedades(sc);
                        if (propiedades.isEmpty()) {
                            System.out.println("No hay propiedades de tipo " + tipoPropiedad + " disponibles.");
                        }    
                        else{
                            System.out.println("Propiedades de tipo " + tipoPropiedad + ":");
                        }
                switch (tipoPropiedad) {
                    case "CASA":
                        int enumeracion1  = 1; 
                        for (Propiedad p : propiedades) {
                            for(Unidad u : p.getUnidades()) {
                                if((u instanceof Casa) && u.estaDisponible()) {
                                    System.out.println(enumeracion1 + ".- " + p.getUbicacion() + " - " + u);
                                    enumeracion1++;
                                }
                            }
                        }
                        break;
                    case "DEPARTAMENTO":
                        int enumeracion2  = 1; 
                        for (Propiedad p : propiedades) {
                            for(Unidad u : p.getUnidades()) {
                                if ((u instanceof DepartamentoCompleto) && u.estaDisponible()) {
                                    System.out.println(enumeracion2 + ".- " + p.getUbicacion() + " - " + u);
                                    enumeracion2++;
                                }
                            }
                        }                    
                        break;
                    case "HABITACION":
                        int enumeracion3  = 1; 
                        for (Propiedad p : propiedades) {
                            for(Unidad u : p.getUnidades()) {
                                if ((u instanceof HabitacionPrivada) && u.estaDisponible()) {
                                    System.out.println(enumeracion3 + ".- " + p.getUbicacion() + " - " + u);
                                    enumeracion3++;
                                }
                            }
                        }               
                        break;
                    default:
                        System.out.println("Tipo de propiedad no válido.");
                }
                break;
            case 4:
                System.out.println("Buscando por servicios...");
                ArrayList<Propiedad> propiedadesConServicio = mostrarPropiedades(sc);
                if (propiedadesConServicio.isEmpty()) {
                    System.out.println("No hay propiedades disponibles.");
                    return;
                }
                System.out.println("Ingrese el servicio que desea buscar (PetFriendly, WiFi, Piscina, Estacionamiento):");
                String servicioBuscado = sc.nextLine().trim();
                int enumeracion4  = 1;
                for (Propiedad p : propiedadesConServicio) {
                    for (Servicio s : p.getServicios()) {
                        if (s.name().toUpperCase().equalsIgnoreCase(servicioBuscado.toUpperCase()) ) {
                            System.out.println(enumeracion4 + ".- " + p.getUbicacion() + " - Servicios: " + p.getServicios());
                            enumeracion4++;
                        }
                    }
                }
                if (enumeracion4 == 1) {
                    System.out.println("No se encontraron propiedades con el servicio: " + servicioBuscado);
                } else {
                System.out.println("Escoger una propiedad para reservar:");
                int opcionPropiedad = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (opcionPropiedad >= 1 && opcionPropiedad <= propiedadesConServicio.size()) {
                    Propiedad propiedadSeleccionada = propiedadesConServicio.get(opcionPropiedad - 1);
                    propiedadSeleccionada.mostrarUnidades();
                    if (propiedadSeleccionada.getUnidades().isEmpty()) {
                        System.out.println("No hay unidades disponibles en esta propiedad.");
                        return;
                    }
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
                } else {
                    System.out.println("Opción de propiedad no válida.");
                }
                }

            


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
        if (HuespedManager.mostrarPropiedades(sc).isEmpty()) {
            System.out.println("No hay propiedades disponibles para reservar.");
            return;
        }
        System.out.println("Propiedades disponibles:");
        int opcionReserva = -1;

        while (true) {
        ArrayList<Propiedad> propiedadesReservar = HuespedManager.mostrarPropiedades(sc);
        if(propiedadesReservar.isEmpty()){
            System.out.println("No hay propiedades disponibles para reservar.");
            return;
        }
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
        System.out.println("Ingrese la calificación (1-5): ");
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

    public static void reportarIncidente(Huesped huesped, Scanner sc) {
        System.out.print("Describe el incidente: ");
        
        String mensaje = sc.nextLine();
        // Dispara la lógica de reportes del huésped
        huesped.reportar(mensaje);

    } 

    public static ArrayList<Unidad> precioMax(double precioMaximo) {
        ArrayList<Unidad> unidades = new ArrayList<>();
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                for (Unidad unidad : propiedad.getUnidades()) {
                    if (unidad.estaDisponible() && unidad.getPrecio() <= precioMaximo) {
                        unidades.add(unidad);
                    }
                }
            }
        }
        return unidades;
    }

    public static ArrayList<Unidad> ubicacionSearch(String ubicacion) {
        ArrayList<Unidad> unidades = new ArrayList<>();
    if (ubicacion == null) throw new NullPointerException("ubicacion no puede ser null");
        for (Anfitrion anfitrion : BaseDatos.getDataBase().getAnfitriones().values()) {
            for (Propiedad propiedad : anfitrion.getPropiedades()) {
                for (Unidad unidad : propiedad.getUnidades()) {
                    if (unidad.estaDisponible() && unidad.getPropiedad().getUbicacion().equalsIgnoreCase(ubicacion)) {
                        unidades.add(unidad);
                    }
                }
            }
        }
        return unidades;
    }

    public static void buscarPorUbicacion(String ubicacion, Scanner sc, Huesped huesped){
        ArrayList<Unidad> unidades2 = ubicacionSearch(ubicacion);
    if (ubicacion == null) throw new NullPointerException("ubicacion no puede ser null");
        int enumeration = 1;
        if (unidades2.isEmpty()){
            System.out.println("No se encontraron unidades disponibles en esa ubicación.");
        } else {
            System.out.println("Unidades disponibles en " + ubicacion + ":");
            for (Unidad unidad : unidades2) {
                System.out.println("Unidad# " + enumeration);
                enumeration++;
                unidad.mostrarDetalles();
            }
            System.out.println("Desea reservar alguna de estas unidades? (S/N)");
            String respuesta = sc.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                System.out.print("Seleccione la unidad que desea reservar (1 a " + unidades2.size() + "): ");
                int opcionUnidad = -1;
                while (true) {
                    if (sc.hasNextInt()) {
                        opcionUnidad = sc.nextInt();
                        sc.nextLine();
                        
                        if (opcionUnidad >= 1 && opcionUnidad <= unidades2.size()) {
                            break; // entrada válida, salir del bucle
                        } else {
                            System.out.println("Número fuera de rango. Intente nuevamente.");
                        }
                        
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                        sc.nextLine(); // limpiar entrada inválida
                    }
                }
                Unidad unidadSeleccionada = unidades2.get(opcionUnidad - 1);
                huesped.reservar(unidadSeleccionada);
                System.out.println("Reserva realizada con éxito.");
            } else {
                System.out.println("No se realizó ninguna reserva.");
            }
    }
}

    public static void buscarPorPrecio(double precioMaximo, Scanner sc, Huesped huesped){
        ArrayList<Unidad> unidades = precioMax(precioMaximo);
        int enumeration2 = 1;
        if (unidades.isEmpty()) {
            System.out.println("No se encontraron unidades disponibles con ese precio máximo.");
        } else {
            System.out.println("Unidades disponibles con precio máximo de $" + precioMaximo + ":");
            for (Unidad unidad : unidades) {
                System.out.println("Unidad# "+enumeration2);
                enumeration2++;
                unidad.mostrarDetalles();
            }
            System.out.println("Desea reservar alguna de estas unidades? (S/N)");
            String respuesta = sc.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                System.out.println("Seleccione la unidad que desea reservar (1 a " + unidades.size() + "): ");
                int opcionUnidad2 = -1;
                while (true) {
                    if (sc.hasNextInt()) {
                        opcionUnidad2 = sc.nextInt();
                        sc.nextLine();
                        
                        if (opcionUnidad2 >= 1 && opcionUnidad2 <= unidades.size()) {
                            break; // entrada válida, salir del bucle
                        } else {
                            System.out.println("Número fuera de rango. Intente nuevamente.");
                        }
                        
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                        sc.nextLine(); // limpiar entrada inválida
                    }
                }
                
                Unidad unidadSeleccionada = unidades.get(opcionUnidad2 - 1);
                huesped.reservar(unidadSeleccionada);
                System.out.println("Reserva realizada con éxito.");
            } else {
                System.out.println("No se realizó ninguna reserva.");
            }
            
        }
    }
    
}

