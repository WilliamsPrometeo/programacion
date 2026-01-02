package recursos;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase utilitaria para la entrada de datos por consola.
 *
 * Centraliza la lectura y validación básica de datos introducidos por el usuario,
 * evitando errores comunes como introducir letras cuando se espera un número
 * o dejar campos obligatorios vacíos.
 */
public class MyScanner {

    /**
     * Scanner interno para la lectura desde la entrada estándar
     */
    private static Scanner sc;

    /**
     * Constructor de la clase MyScanner.
     * Inicializa el objeto {@link Scanner}.
     */
    public MyScanner() {
        sc = new Scanner(System.in);
    }

    /**
     * Solicita al usuario un número entero.
     *
     * Muestra el mensaje indicado y repite la petición hasta que
     * el usuario introduce un valor numérico válido.
     *
     * @param mns mensaje que se muestra al usuario.
     * @return número entero introducido por el usuario.
     */
    public int pedirNumero(String mns) {
        int n = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(mns);
                n = sc.nextInt();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es número!");
                sc.nextLine();
            }
        }
        return n;
    }

    /**
     * Solicita al usuario un número decimal.
     *
     * Muestra el mensaje indicado y repite la petición hasta que
     * el usuario introduce un valor decimal válido.
     *
     * @param mns mensaje que se muestra al usuario.
     * @return número decimal introducido por el usuario.
     */
    public double pedirDecimal(String mns) {
        double num = -1;
        boolean flag = true;
        while (flag) {
            try {
                System.out.printf(mns);
                num = sc.nextDouble();
                sc.nextLine();
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Eso no es número!");
                sc.nextLine();
            }
        }
        return num;
    }

    /**
     * Solicita al usuario una cadena de texto que contenga únicamente letras.
     *
     * No se permiten números ni símbolos.
     * El metodo repite la petición hasta que el texto introducido es válido.
     *
     * @param texto mensaje que se muestra al usuario.
     * @return texto introducido válido.
     */
    public String pedirSoloTexto(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]+");
            if (!valido) {
                System.out.println("ERROR: solo se permiten letras (sin números ni símbolos). Inténtalo de nuevo.");
            }
        } while (!valido);
        return input;
    }

    /**
     * Solicita al usuario una única letra.
     *
     * El metodo valida que el usuario introduzca exactamente un carácter alfabético.
     *
     * @param texto mensaje que se muestra al usuario.
     * @return carácter introducido por el usuario.
     */
    public char pedirLetra(String texto) {
        String input;
        boolean valido;
        do {
            System.out.println(texto);
            input = sc.nextLine().trim();
            valido = input.matches("[a-zA-ZáéíóúüÁÉÍÓÚÜñÑ ]");
            if (!valido) {
                System.out.println("ERROR: solo se permite introducir una letra. Inténtalo de nuevo.");
            }
        } while (!valido);

        return input.charAt(0);
    }

    /**
     * Solicita al usuario una cadena de texto no vacía.
     *
     * El metodo repite la petición mientras el texto esté vacío.
     *
     * @param mensaje mensaje que se muestra al usuario.
     * @return texto introducido por el usuario.
     */
    public String pideTexto(String mensaje) {
        String texto;
        do {
            System.out.println(mensaje);
            texto = sc.nextLine();
            if (texto.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    /**
     * Cierra el scanner asociado a la entrada estándar.
     */
    public void cerrar() {
        sc.close();
    }
}
