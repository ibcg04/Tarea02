    package ec.edu.espol.ui;

    import ec.edu.espol.logica.BuscadorPropiedades;
    import ec.edu.espol.logica.HuespedManager;
    import ec.edu.espol.modelo.Huesped;
    import ec.edu.espol.modelo.Propiedad;
    import ec.edu.espol.modelo.Unidad;
    import java.util.ArrayList;
    import java.util.Scanner;

    public class HuespedUI {

        // Mensajes constantes para evitar repetición
    private static final String MSG_ENTRADA_INVALIDA = "Entrada inválida. Por favor, ingrese un número entero.";
    private static final String MSG_NUMERO_FUERA_RANGO = "Número fuera de rango. Intente nuevamente.";
    private static final String MSG_NO_UNIDADES = "No hay unidades disponibles en esta propiedad.";
    private static final String MSG_RESERVA_EXITOSA = "Reserva realizada con éxito.";
    private static final String MSG_NO_RESERVA = "No se realizó ninguna reserva.";
    private static final String MSG_NO_PROPIEDADES = "No hay propiedades disponibles.";
    /**
     * Menú principal de búsqueda de propiedades para el huésped.
     */
    public static void buscarPropiedades(Huesped huesped, Scanner sc) {
        System.out.println("==========Buscar Propiedades==========");
        System.out.println("1. Buscar por ubicación");
        System.out.println("2. Buscar por precio");
        System.out.println("3. Buscar por tipo de propiedad");
        System.out.println("4. Buscar por servicios");
        System.out.println("5. Volver al menú principal");

        int opcion = -1;
        while (opcion < 1 || opcion > 5) {
            System.out.print("Seleccione una opción (1-5): ");
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println(MSG_ENTRADA_INVALIDA);
                sc.nextLine();
            }
        }

        switch (opcion) {
            case 1: {
                System.out.println("Buscando por ubicación...");
                System.out.print("Ingrese la ubicación que desea buscar: ");
                String ubicacion = sc.nextLine();
                ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorUbicacion(ubicacion);
                mostrarUnidadesYReservar(unidades, huesped, sc);
                break;
            }
            case 2: {
                System.out.println("Buscando por precio...");
                double precioMaximo = -1;
                while (true) {
                    System.out.print("Ingrese el valor máximo que desea buscar: ");
                    if (sc.hasNextDouble()) {
                        precioMaximo = sc.nextDouble();
                        sc.nextLine();
                        if (precioMaximo >= 1) {
                            break;
                        } else {
                            System.out.println(MSG_NUMERO_FUERA_RANGO);
                        }
                    } else {
                        System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                        sc.nextLine();
                    }
                }
                ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorPrecio(precioMaximo);
                mostrarUnidadesYReservar(unidades, huesped, sc);
                break;
            }
            case 3: {
                System.out.println("Buscando por tipo de propiedad...");
                System.out.print("Ingrese el tipo de propiedad que desea buscar (CASA, DEPARTAMENTO, HABITACION): ");
                String tipoPropiedad = sc.nextLine().trim().toUpperCase();
                ArrayList<Unidad> unidades = BuscadorPropiedades.buscarPorTipo(tipoPropiedad);
                mostrarUnidadesYReservar(unidades, huesped, sc);
                break;
            }
            case 4: {
                System.out.println("Buscando por servicios...");
                System.out.print("Ingrese el servicio que desea buscar (PetFriendly, WiFi, Piscina, Estacionamiento): ");
                String servicioBuscado = sc.nextLine().trim();
                ArrayList<Propiedad> propiedades = BuscadorPropiedades.buscarPorServicio(servicioBuscado);
                int enumeracion = 1;
                if (propiedades.isEmpty()) {
                    System.out.println("No se encontraron propiedades con el servicio: " + servicioBuscado);
                } else {
                    System.out.println("Propiedades con servicio " + servicioBuscado + ":");
                    for (Propiedad p : propiedades) {
                        System.out.println(enumeracion + ".- " + p.getUbicacion() + " - Servicios: " + p.getServicios());
                        enumeracion++;
                    }
                    System.out.print("Escoger una propiedad para reservar: ");
                    int opcionPropiedad = -1;
                    while (true) {
                        if (sc.hasNextInt()) {
                            opcionPropiedad = sc.nextInt();
                            sc.nextLine();
                            if (opcionPropiedad >= 1 && opcionPropiedad <= propiedades.size()) {
                                break;
                            } else {
                                System.out.println("Opción fuera de rango. Intente nuevamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                            sc.nextLine();
                        }
                    }
                    Propiedad propiedadSeleccionada = propiedades.get(opcionPropiedad - 1);
                    propiedadSeleccionada.mostrarUnidades();
                    if (propiedadSeleccionada.getUnidades().isEmpty()) {
                        System.out.println("No hay unidades disponibles en esta propiedad.");
                        return;
                    }
                    System.out.print("Seleccione la Unidad que deseas RESERVAR : (1 a " + propiedadSeleccionada.getUnidades().size() + "): ");
                    int opcionUnidad = -1;
                    while (true) {
                        if (sc.hasNextInt()) {
                            opcionUnidad = sc.nextInt();
                            sc.nextLine();
                            if (opcionUnidad >= 1 && opcionUnidad <= propiedadSeleccionada.getUnidades().size()) {
                                break;
                            } else {
                                System.out.println("Número fuera de rango. Intente nuevamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                            sc.nextLine();
                        }
                    }
                    Unidad unidadSeleccionada = propiedadSeleccionada.getUnidades().get(opcionUnidad - 1);
                    HuespedManager.reservarUnidad(huesped, unidadSeleccionada);
                    System.out.println("Reserva realizada con éxito.");
                }
                break;
            }
            case 5: {
                System.out.println("Volviendo al menú principal...");
                // Aquí deberías llamar al menú principal correspondiente
                break;
            }
            default:
                break;
        }
    }


    /**
     * Muestra una lista de unidades y permite al usuario reservar una.
     */
    private static void mostrarUnidadesYReservar(ArrayList<Unidad> unidades, Huesped huesped, Scanner sc) {
        int enumeration = 1;
        if (unidades.isEmpty()) {
            System.out.println(MSG_NO_UNIDADES);
        } else {
            System.out.println("Unidades disponibles:");
            for (Unidad unidad : unidades) {
                System.out.println("Unidad# " + enumeration);
                enumeration++;
                unidad.mostrarDetalles();
            }
            System.out.println("¿Desea reservar alguna de estas unidades? (S/N)");
            String respuesta = sc.nextLine().trim().toUpperCase();
            if (respuesta.equals("S")) {
                System.out.print("Seleccione la unidad que desea reservar (1 a " + unidades.size() + "): ");
                int opcionUnidad = -1;
                while (true) {
                    if (sc.hasNextInt()) {
                        opcionUnidad = sc.nextInt();
                        sc.nextLine();
                        if (opcionUnidad >= 1 && opcionUnidad <= unidades.size()) {
                            break;
                        } else {
                            System.out.println(MSG_NUMERO_FUERA_RANGO);
                        }
                    } else {
                        System.out.println(MSG_ENTRADA_INVALIDA);
                        sc.nextLine();
                    }
                }
                Unidad unidadSeleccionada = unidades.get(opcionUnidad - 1);
                HuespedManager.reservarUnidad(huesped, unidadSeleccionada);
                System.out.println(MSG_RESERVA_EXITOSA);
            } else {
                System.out.println(MSG_NO_RESERVA);
            }
        }
    }

    /**
     * Permite al usuario reservar una propiedad y una unidad disponible.
     */
    public static void reservarPropiedad(Huesped huesped, Scanner sc) {
        System.out.println("Reservando Propiedad...");
        ArrayList<Propiedad> propiedades = HuespedManager.obtenerPropiedadesDisponibles();
        if (propiedades.isEmpty()) {
            System.out.println(MSG_NO_PROPIEDADES);
            return;
        }
        int enumeration = 1;
        for (Propiedad p : propiedades) {
            System.out.println(enumeration + ".- " + p);
            enumeration++;
        }
        int opcionReserva = -1;
        while (true) {
            System.out.print("Seleccione una Propiedad: (1 a " + propiedades.size() + "): ");
            if (sc.hasNextInt()) {
                opcionReserva = sc.nextInt();
                sc.nextLine();
                if (opcionReserva >= 1 && opcionReserva <= propiedades.size()) {
                    break;
                } else {
                    System.out.println(MSG_NUMERO_FUERA_RANGO);
                }
            } else {
                System.out.println(MSG_ENTRADA_INVALIDA);
                sc.nextLine();
            }
        }
        Propiedad propiedadSeleccionada = propiedades.get(opcionReserva - 1);
        propiedadSeleccionada.mostrarUnidades();
        if (propiedadSeleccionada.getUnidades().isEmpty()) {
            System.out.println(MSG_NO_UNIDADES);
            return;
        }
        int opcionUnidad = -1;
        while (true) {
            System.out.print("Seleccione la Unidad que deseas RESERVAR : (1 a " + propiedadSeleccionada.getUnidades().size() + "): ");
            if (sc.hasNextInt()) {
                opcionUnidad = sc.nextInt();
                sc.nextLine();
                if (opcionUnidad >= 1 && opcionUnidad <= propiedadSeleccionada.getUnidades().size()) {
                    break;
                } else {
                    System.out.println(MSG_NUMERO_FUERA_RANGO);
                }
            } else {
                System.out.println(MSG_ENTRADA_INVALIDA);
                sc.nextLine();
            }
        }
        Unidad unidadSeleccionada = propiedadSeleccionada.getUnidades().get(opcionUnidad - 1);
        HuespedManager.reservarUnidad(huesped, unidadSeleccionada);
    System.out.println(MSG_RESERVA_EXITOSA);
    }

    /**
     * Permite al usuario generar una reseña para la unidad ocupada.
     */
    public static void generarReseña(Huesped huesped, Scanner sc) {
        System.out.println("Generando reseña...");
        int calificacion = -1;
        while (true) {
            System.out.print("Ingrese la calificación (1-5): ");
            if (sc.hasNextInt()) {
                calificacion = sc.nextInt();
                sc.nextLine();
                if (calificacion >= 1 && calificacion <= 5) {
                    break;
                } else {
                    System.out.println(MSG_NUMERO_FUERA_RANGO);
                }
            } else {
                System.out.println(MSG_ENTRADA_INVALIDA);
                sc.nextLine();
            }
        }
        System.out.print("Ingrese la descripción de la reseña: ");
        String descripcion = sc.nextLine();
        boolean exito = HuespedManager.generarReseña(huesped, calificacion, descripcion);
        if (exito) {
            System.out.println(MSG_RESERVA_EXITOSA);
        } else {
            System.out.println(MSG_NO_RESERVA);
        }
    }

    /**
     * Permite al usuario reportar un incidente.
     */
    public static void reportarIncidente(Huesped huesped, Scanner sc) {
        System.out.print("Describe el incidente: ");
        String mensaje = sc.nextLine();
        HuespedManager.reportarIncidente(huesped, mensaje);
        System.out.println("Incidente reportado.");
    }

}
