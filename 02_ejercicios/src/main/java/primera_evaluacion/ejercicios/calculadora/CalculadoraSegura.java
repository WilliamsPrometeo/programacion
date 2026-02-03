package primera_evaluacion.ejercicios.calculadora;

import primera_evaluacion.ejercicios.calculadora.clases.Calculadora;
import recursos.MyScanner;
import primera_evaluacion.ejercicios.calculadora.exceptions.DivisionPorCeroException;


public class CalculadoraSegura {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();

        try {
            double num1 = sc.pedirDecimal("Introduce el primer número: ");

            double num2 = sc.pedirDecimal("Introduce el segundo número: ");

            double resultado = Calculadora.dividir(num1, num2);
            System.out.printf("✅ Resultado: %.2f ÷ %.2f = %.2f%n", num1, num2, resultado);

        } catch (DivisionPorCeroException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("🧮 Fin del programa.");
            sc.cerrar();
        }
    }
}
