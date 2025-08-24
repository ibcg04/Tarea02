package utilidades;

import java.util.Scanner;

public class EntradaUtils {


    public static int validarEntradaEntero(Scanner sc, String mensaje, int min, int max) {
        int numero = -1;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                if (numero >= min && numero <= max) {
                    return numero; // Entrada válida
                } else {
                    System.out.println("Número fuera de rango. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine(); // Limpiar entrada inválida
            }
        }
    }
}