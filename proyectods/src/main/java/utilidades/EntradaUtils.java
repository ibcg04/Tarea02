package utilidades;

import java.util.Scanner;

public class EntradaUtils {

    /**
     * Valida la entrada de un número entero dentro de un rango específico.
     *
     * @param sc       Scanner para leer la entrada del usuario.
     * @param mensaje  Mensaje que se mostrará al usuario.
     * @param min      Valor mínimo permitido (inclusive).
     * @param max      Valor máximo permitido (inclusive).
     * @return         El número entero válido ingresado por el usuario.
     */
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