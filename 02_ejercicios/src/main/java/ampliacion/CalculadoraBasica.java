package ampliacion;

import recursos.MyScanner;

public class CalculadoraBasica {

    private static final MyScanner sc = new MyScanner();

    public static void main (String[] args) {
        double num1 = pedirNumero("Introduce el número 1: ");
        double num2 = pedirNumero("Introduce el numero 2: ");
        System.out.println("==== RESUMEN ====");
        System.out.println("Número 1: "+num1);
        System.out.println("Número 2: "+num2);
        System.out.println("Suma: " + sumar(num1, num2));
        System.out.println("Resta: " + restar(num1, num2));
        System.out.println("Multiplicación: " + multiplicar(num1, num2));
        try {
            System.out.println("Dividir: " + divir(num1, num2));
        } catch (DivsionException e) {
            System.out.println("Dividir: " + e.getMessage());
        }
    }

    public static double pedirNumero(String mensaje) {
        boolean correcto;
        double numero;
        do {
            numero = sc.pedirDecimal(mensaje);
            if (numero<0 || numero>100) {
                System.out.println("Error: Valor introducido erroneo. Rango del 0 al 100 válidos.");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);
        return numero;
    }

    public static double sumar (double num1, double num2) {
        return num1 + num2;
    }

    public static double sumar (double num1, double num2, double c){
        return num1 + num2 + c;
    }

    public static double restar (double a, double b) {
        return a - b;
    }

    public static double multiplicar (double a, double b) {
        return a * b;
    }

    public static double divir (double a, double b) throws DivsionException {
        if (b == 0) {
            throw new DivsionException("No se puede dividir entre 0.");
        }
        return a / b;
    }
}
