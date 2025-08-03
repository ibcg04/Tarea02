import java.util.Scanner;
import modelo.BaseDatos;
import modelo.Huesped;

public class InicioSesion {
    public static void iniciarSesionHuesped() {
        System.out.println("==========Inicio de sesión Huesped==========");
        BaseDatos db = BaseDatos.getDataBase();
        db.mostrarHuespedes();
        System.out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        if (opcion == 0) {
            System.out.println("Saliendo del programa...");
            sc.close();
            Main.gestionarAplicacion(); // Termina el programa
        }
        if (db.getHuespedes().containsKey(opcion)) {
            System.out.println("Sesión iniciada como Huesped con ID: " + opcion);
            Huesped huesped = db.getHuespedes().get(opcion);
            MenuHuesped.mostrarMenu(huesped);
        } else {
            System.out.println("ID de Huesped no encontrado. Intente nuevamente.");
            iniciarSesionHuesped(); // Vuelve a intentar iniciar sesión
        }

        sc.close();

    }

    public static void iniciarSesionAnfitrion() {
        System.out.println("==========Inicio de sesión Anfitrión==========");
        BaseDatos db = BaseDatos.getDataBase();
        db.mostrarAnfitriones();
        System.out.println("0. Salir");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        if (opcion == 0) {
            System.out.println("Saliendo del programa...");
            sc.close();
            Main.gestionarAplicacion();
        }
        if (db.getAnfitriones().containsKey(opcion)) {
            System.out.println("Sesión iniciada como Anfitrión con ID: " + opcion);
        } else {
            System.out.println("ID de Anfitrión no encontrado. Intente nuevamente.");
            iniciarSesionAnfitrion(); // Vuelve a intentar iniciar sesión
        }

        sc.close();
        
    }
}