package ec.edu.espol;
import java.util.Scanner;

import ec.edu.espol.modelo.Anfitrion;
import ec.edu.espol.modelo.BaseDatos;
import ec.edu.espol.modelo.Huesped;

public class RegistrarUsuario {

    public static void registro(Scanner sc) {
        while (true) {
            System.out.println("==========Registro de Usuario==========");
            System.out.println("1. Registrar Huesped");
            System.out.println("2. Registrar Anfitrión");
            System.out.println("3. Regresar");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Registrando nuevo Huesped...");
                    registrarHuesped(sc);
                    break;
                case 2:
                    System.out.println("Registrando nuevo Anfitrión...");
                    registrarAnfitrion(sc);
                    break;
                case 3:
                    System.out.println("Regresando...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    break;
            }
        }
    }

    public static void registrarHuesped(Scanner sc) {
        System.out.println("Ingrese el nombre del Huesped:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el ID del Huesped:");
        int id = sc.nextInt();
        sc.nextLine();

        Huesped huesped = new Huesped(nombre, id);
        BaseDatos db = BaseDatos.getDataBase();
        db.agregarHuesped(huesped);

        System.out.println("Huesped registrado exitosamente: " + huesped.toString());
    }

    public static void registrarAnfitrion(Scanner sc) {
        System.out.println("Ingrese el nombre del Anfitrión:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el ID del Anfitrión:");
        int id = sc.nextInt();
        sc.nextLine();

        Anfitrion anfitrion = new Anfitrion(nombre, id);
        BaseDatos db = BaseDatos.getDataBase();
        db.agregarAnfitrion(anfitrion);

        System.out.println("Anfitrión registrado exitosamente: " + anfitrion);
    }
}
