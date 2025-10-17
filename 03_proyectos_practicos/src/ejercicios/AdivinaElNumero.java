package ejercicios;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AdivinaElNumero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🎯 Bienvenido al juego Adivina el Número 🎯");

        boolean jugarDeNuevo;
        do {
            jugar(sc);
            jugarDeNuevo = preguntarRepetir(sc);
        } while (jugarDeNuevo);

        System.out.println("👋 ¡Gracias por jugar! Hasta la próxima.");
        sc.close();
    }

    // Metodo principal del juego
    public static void jugar(Scanner sc) {
        int numeroSecreto = generarNumeroAleatorio(1, 100);
        int intentos = 0;
        boolean adivinado = false;

        System.out.println("\nHe pensado un número entre 1 y 100... ¿puedes adivinarlo?");

        while (!adivinado) {
            int intento = pedirNumero(sc);
            intentos++;

            if (intento < 1 || intento > 100) {
                System.out.println("❌ El número debe estar entre 1 y 100.");
            } else if (intento < numeroSecreto) {
                System.out.println("📉 Demasiado bajo. ¡Intenta con un número mayor!");
            } else if (intento > numeroSecreto) {
                System.out.println("📈 Demasiado alto. ¡Intenta con un número menor!");
            } else {
                System.out.println("🎉 ¡Correcto! Has adivinado el número en " + intentos + " intentos.");
                adivinado = true;
            }
        }
    }

    // Metodo que genera un número aleatorio dentro de un rango
    public static int generarNumeroAleatorio(int minimo, int maximo) {
        Random random = new Random();
        return random.nextInt(maximo - minimo + 1) + minimo;
    }

    // Metodo que pide al usuario un número y valida que sea un entero
    public static int pedirNumero(Scanner sc) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            System.out.print("👉 Introduce tu número: ");
            try {
                numero = sc.nextInt();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Por favor, introduce un número válido.");
                sc.next(); // Limpiar buffer
            }
        }

        return numero;
    }

    // Metodo para preguntar si el jugador quiere repetir
    public static boolean preguntarRepetir(Scanner sc) {
        String respuesta;
        do {
            System.out.print("\n¿Quieres jugar otra vez? (s/n): ");
            respuesta = sc.next().toLowerCase();
        } while (!respuesta.equals("s") && !respuesta.equals("n"));

        return respuesta.equals("s");
    }
}
