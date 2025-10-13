import java.util.Scanner;

public class Figuras {
    public static void main(String[] args) {
        cuadradoRelleno();
        cuadradoVacio();
        arbolNavidad();
        rectangulo();
    }

    public static void cuadradoRelleno() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduzca la dimensión del cuadrado: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void cuadradoVacio() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduzca la dimensión del cuadrado: ");
        int size = sc.nextInt();

        for (int i = 0; i < size; i++) {         // Filas
            for (int j = 0; j < size; j++) {     // Columnas
                // Imprimir * solo en bordes (primera fila, última fila, primera columna o última columna)
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  "); // Espacios en el interior
                }
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    public static void arbolNavidad() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduzca la altura del arbol: ");
        int altura = sc.nextInt();

        for (int i = 1; i <= altura; i++) {
            // Espacios en blanco antes de los asteriscos
            for (int j = 1; j <= altura - i; j++) {
                System.out.print(" ");
            }
            // Asteriscos
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println(); // salto de línea
        }
    }

    public static void rectangulo() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Introduzca la base: ");
        int base = sc.nextInt();
        System.out.printf("Introduzca la altura: ");
        int altura = sc.nextInt();

        for (int i = 0; i < altura; i++){
            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
