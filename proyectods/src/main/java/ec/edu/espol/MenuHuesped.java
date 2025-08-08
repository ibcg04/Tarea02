package ec.edu.espol;
import java.util.Scanner;

import logica.HuespedManager;
import modelo.Huesped;

public class MenuHuesped {
   public static void mostrarMenu(Huesped huesped, Scanner sc) {
        if (huesped == null) {
            System.out.println("No se ha iniciado sesión como Huesped.");
            return;
        }

        while (true) {
            System.out.println("==========Menú Huesped==========");
            System.out.println("1. Buscar Propiedades");
            System.out.println("2. Reservar Propiedad");
            System.out.println("3. Ver Reservas");
            System.out.println("4. Reportar incidente");
            System.out.println("5. Hacer reseña");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Buscando Propiedades...");
                    HuespedManager.mostrarPropiedades(sc);
                    break;
                case 2:
                    System.out.println("Reservando Propiedad...");
                    HuespedManager.reservarPropiedad(huesped, sc);
                    break;
                case 3:
                    System.out.println("Ver Reserva...");
                    huesped.mostrarReservas();
                    break;
                case 4:
                    System.out.println("Haciendo reseña...");
                    HuespedManager.generarReseña(huesped, sc);
                    break;
                case 5:
                    System.out.println("Reportando incidente...");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        
        }
        
}
}

