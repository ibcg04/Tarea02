import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        gestionarAplicacion();
    }

    public static void gestionarAplicacion() {
        System.out.println("==========Bienvenido a HomeStay!==========");
        System.out.println("1. Iniciar sesión como Huesped");
        System.out.println("2. Iniciar sesión como Anfitrión");
        System.out.println("3. Registrar nuevo usuario");
        System.out.println("4. Salir");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Iniciando sesión como Huesped...");
                InicioSesion.iniciarSesionHuesped();
                break;
            case 2:
                System.out.println("Iniciando sesión como Anfitrión...");
                InicioSesion.iniciarSesionAnfitrion();
                break;
            case 3:
                System.out.println("Registrando nuevo usuario...");
                RegistrarUsuario.registro();
                break;
            case 4:
                System.out.println("Saliendo del programa...");
                sc.close();
                return; // Termina el programa
            default:
                break;
        }
        sc.close();
    }

}