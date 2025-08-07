package ec.edu.espol;
import java.util.Scanner;
import modelo.BaseDatos;
import modelo.Huesped;
import modelo.Anfitrion;

public class RegistrarUsuario {

    public static void registro() {
        System.out.println("==========Registro de Usuario==========");
        System.out.println("1. Registrar Huesped");
        System.out.println("2. Registrar Anfitrión");
        System.out.println("3. Volver al menú principal");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Registrando nuevo Huesped...");
                sc.close();
                registrarHuesped();
                break;
            case 2:
                System.out.println("Registrando nuevo Anfitrión...");
                sc.close();
                registrarAnfitrion();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                sc.close();
                Main.gestionarAplicacion();
                break;
            default:
                break;
        }
    }

    public static void registrarHuesped() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Huesped:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el ID del Huesped:");
        int id = sc.nextInt();

        Huesped huesped = new Huesped(nombre, id);
        BaseDatos db = BaseDatos.getDataBase();
        db.agregarHuesped(huesped);

        System.out.println("Huesped registrado exitosamente: " + huesped);
        sc.close();

        Main.gestionarAplicacion();
    }

    public static void registrarAnfitrion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Anfitrión:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el ID del Anfitrión:");
        int id = sc.nextInt();

        Anfitrion anfitrion = new Anfitrion(nombre, id);
        BaseDatos db = BaseDatos.getDataBase();
        db.agregarAnfitrion(anfitrion);

        System.out.println("Anfitrión registrado exitosamente: " + anfitrion);
        sc.close();

        Main.gestionarAplicacion();
    }
}
