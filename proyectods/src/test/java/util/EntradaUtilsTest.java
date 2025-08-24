package util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import utilidades.EntradaUtils;

class EntradaUtilsTest {

    @Test
    @DisplayName("Entrada válida dentro de rango retorna el valor ingresado")
    void testEntradaValidaDentroDeRango() {
        String input = "5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Entrada fuera de rango seguida de válida retorna la segunda entrada")
    void testEntradaFueraDeRangoLuegoValida() {
        String input = "15\n7\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(7, result);
    }

    @Test
    @DisplayName("Entrada no entera seguida de válida retorna la segunda entrada")
    void testEntradaNoEnteraLuegoValida() {
        String input = "abc\n3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Entrada en el límite inferior retorna el valor mínimo")
    void testEntradaEnElLimiteInferior() {
        String input = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(1, result);
    }

    @Test
    @DisplayName("Entrada en el límite superior retorna el valor máximo")
    void testEntradaEnElLimiteSuperior() {
        String input = "10\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(10, result);
    }
}