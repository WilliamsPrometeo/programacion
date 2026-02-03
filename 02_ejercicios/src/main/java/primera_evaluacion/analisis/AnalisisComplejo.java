package primera_evaluacion.analisis;

import recursos.MyScanner;

public class AnalisisComplejo {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        int numero = sc.pedirNumero("Introduce el número: ");
        int resultado = 0;
        int contador = 1;

        System.out.println("Numero inicial: " + numero);

        while (contador <= numero) {

            if (contador % 2 == 0) {
                resultado += contador;
            } else {
                resultado -= (contador - 1);
            }

            if (contador % 3 == 0) {
                resultado *= -1;
            }

            if (resultado == 0 && contador > 1) {
                resultado = contador * 2;
            }

            System.out.println("Paso " + contador + " → Resultado parcial: " + resultado);

            contador++;
        }

        System.out.println("\n=== SEGUNDA FASE ===");

        int acumulador = 1;

        for (int i = 1; i <= numero; i++) {

            if (i % 2 != 0) {
                acumulador += i;
            } else if (i % 4 == 0) {
                acumulador -= (i / 2);
            } else {
                acumulador *= -1;
            }

            if (acumulador > resultado) {
                acumulador = acumulador / 2;
            } else if (acumulador == resultado) {
                acumulador += 3;
            }

            System.out.println("Iteración " + i + " → Acumulador: " + acumulador);
        }

        System.out.println("\n=== RESULTADO FINAL ===");

        if (acumulador > resultado) {
            System.out.println("SALIDA: A");
        } else if (acumulador == resultado) {
            System.out.println("SALIDA: B");
        } else if (acumulador < 0) {
            System.out.println("SALIDA: C");
        } else {
            System.out.println("SALIDA: D");
        }
    }
}
