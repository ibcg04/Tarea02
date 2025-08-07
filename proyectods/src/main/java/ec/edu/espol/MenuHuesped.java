package ec.edu.espol;
import modelo.Huesped;
import java.util.Scanner;

public class MenuHuesped {
   public static void mostrarMenu(Huesped huesped) {
        if (huesped == null) {
            System.out.println("No se ha iniciado sesión como Huesped.");
            Main.gestionarAplicacion();
        }
        System.out.println("==========Menú Huesped==========");
        System.out.println("1. Buscar Propiedades");
        System.out.println("2. Reservar Propiedad");
        System.out.println("3. Ver Reservas");
        System.out.println("4. Salir");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Buscando Propiedades...");
                sc.close();
                break;
            case 2:
                System.out.println("Reservando Propiedad...");
                sc.close();
                break;
            case 3:
                System.out.println("Ver Reservas...");
                sc.close();
                break;
            case 4:
                System.out.println("Saliendo...");
                sc.close();
                Main.gestionarAplicacion();
                break;
            default:
                break;
        }
   }
}
