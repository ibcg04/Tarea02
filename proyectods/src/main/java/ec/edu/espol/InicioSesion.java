package ec.edu.espol;
import java.util.Scanner;

import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.BaseDatos;
import ec.edu.espol.modelo.Huesped;

public class InicioSesion {
    private InicioSesion(){
        throw new IllegalStateException("Utility Class");
    }
    public static void iniciarSesionHuesped(Scanner sc) {
        System.out.println("==========Inicio de sesión Huesped==========");
        BaseDatos db = BaseDatos.getDataBase();

        if (!db.hasHuespedes()) {
            System.out.println("Error no existen Huespedes registrados. Registrese como Huesped y vuelva a intentar");
            return;
        }

        while (true) {
            System.out.println("Seleccione el ID del Huesped para iniciar sesión:");
            db.mostrarHuespedes();
            System.out.println("0. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                return;
            }
            else if (db.getHuespedes().containsKey(opcion)) {
                System.out.println("Sesión iniciada como Huesped con ID: " + opcion);
                Huesped huesped = db.getHuespedes().get(opcion);
                MenuHuesped.mostrarMenu(huesped, sc);
                return;
            } 
            else {
                System.out.println("ID de Huesped no encontrado. Intente nuevamente.");
            }
        }
    }

    public static void iniciarSesionAnfitrion(Scanner sc) {
        System.out.println("==========Inicio de sesión Anfitrión==========");
        BaseDatos db = BaseDatos.getDataBase();

        if (!db.hasAnfitriones()) {
            System.out.println("Error no existen Anfitriones registrados. Registrese como Anfitrion y vuelva a intentar");
            return;
        }

        while (true) {
            System.out.println("Seleccione el ID del Anfitrión para iniciar sesión:");
            db.mostrarAnfitriones();
            System.out.println("0. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 0) {
                System.out.println("Saliendo del programa...");
                return;
            }
            else if (db.getAnfitriones().containsKey(opcion)) {
                System.out.println("Sesión iniciada como Anfitrión con ID: " + opcion);
                Anfitrion anfitrion = db.getAnfitriones().get(opcion);
                MenuAnfitrion.mostrarMenu(anfitrion, sc);
                return;
            } 
            else {
                System.out.println("ID de Anfitrión no encontrado. Intente nuevamente.");
            }
        }
    }
}