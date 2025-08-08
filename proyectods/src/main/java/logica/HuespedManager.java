package logica;

import java.util.Scanner;

import ec.edu.espol.MenuHuesped;
import modelo.BaseDatos;
import modelo.Huesped;

public class HuespedManager {
    public void buscarPropiedades(Huesped huesped) {
        System.out.println("==========Buscar Propiedades==========");
        System.out.println("1. Buscar por ubicación");
        System.out.println("2. Buscar por precio");
        System.out.println("3. Buscar por tipo de propiedad");
        System.out.println("4. Buscar por servicios");
        System.out.println("5. Volver al menú principal");

        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Buscando por ubicación...");
                
                break;
            case 2:
                System.out.println("Buscando por precio...");
                break;
            case 3:
                System.out.println("Buscando por tipo de propiedad...");
                break;
            case 4:
                System.out.println("Buscando por servicios...");
                break;
            case 5:
                System.out.println("Volviendo al menú principal...");
                MenuHuesped.mostrarMenu(huesped,sc);
                break;
            default:
                break;
        }

    }
}
