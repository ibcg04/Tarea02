package ec.edu.espol;
import java.util.Scanner;

import logica.AnfitrionManager;
import modelo.Anfitrion;

public class MenuAnfitrion {
    public static void mostrarMenu(Anfitrion anfitrion, Scanner sc) {
        if (anfitrion == null) {
            System.out.println("No se ha iniciado sesión como Anfitrion.");
            Main.gestionarAplicacion();
        }

        while (true) {
            System.out.println("==========Menú Anfitrión==========");
            System.out.println("1. Ver propiedades");
            System.out.println("2. Manejar propiedades");
            System.out.println("3. Manejar incidentes");
            System.out.println("4. Hacer reseña");
            System.out.println("5. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ver propiedades...");
                    anfitrion.mostrarPropiedades();
                    break;
                case 2:
                    System.out.println("Manejar propiedades...");
                    AnfitrionManager.manejarPropiedades(anfitrion, sc);
                    break;
                case 3:
                    System.out.println("Manejando incidentes...");
                    break;
                case 4:
                    System.out.println("Haciendo reseña...");
                    
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
   }
}
