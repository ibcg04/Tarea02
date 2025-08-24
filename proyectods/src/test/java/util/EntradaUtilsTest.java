package util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import utilidades.EntradaUtils;

class EntradaUtilsTest {

    @Test
    void testEntradaValidaDentroDeRango() {
        String input = "5\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(5, result);
    }

    @Test
    void testEntradaFueraDeRangoLuegoValida() {
        String input = "15\n7\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(7, result);
    }

    @Test
    void testEntradaNoEnteraLuegoValida() {
        String input = "abc\n3\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(3, result);
    }

    @Test
    void testEntradaEnElLimiteInferior() {
        String input = "1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(1, result);
    }

    @Test
    void testEntradaEnElLimiteSuperior() {
        String input = "10\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
        int result = EntradaUtils.validarEntradaEntero(sc, "Ingrese un número:", 1, 10);
        assertEquals(10, result);
    }
}