package calculadora.clases;

import calculadora.exceptions.DivisionPorCeroException;

public class Calculadora {

    // Metodo para dividir dos números con manejo de excepción
    public static double dividir(double a, double b) throws DivisionPorCeroException {
        if (b == 0) {
            throw new DivisionPorCeroException("❌ No se puede dividir entre 0.");
        }
        return a / b;
    }

    private static int suma(int a, int b) {
        return a + b;
    }

    private static int suma(int a, int b, int c) {
        return a + b + c;
    }

    private static double suma(double a, double b) {
        return a + b;
    }

    private static int resta(int a, int b) {
        return a - b;
    }
    private static int multiplicacion(int a, int b) {
        return a * b;
    }

}
