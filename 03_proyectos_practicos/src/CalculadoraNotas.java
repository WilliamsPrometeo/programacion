import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraNotas {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("📘 Bienvenido a la Calculadora de Notas 📘");
        System.out.println("----------------------------------------");

        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Double> medias = new ArrayList<>();

        boolean continuar = true;

        while (continuar) {
            String nombre = pideTexto("\n👩‍🎓 Introduce el nombre del alumno: ");
            double media = calculaMediaAlumno(nombre);

            nombres.add(nombre);
            medias.add(media);

            continuar = preguntarContinuar();
        }

        mostrarResultados(nombres, medias);
        sc.close();
    }

    // -----------------------------------------------------
    // MÉTODOS DE ENTRADA DE DATOS
    // -----------------------------------------------------

    public static double pideNota(String mensaje) {
        double nota = -1;
        boolean valido = false;

        while (!valido) {
            System.out.print(mensaje);
            try {
                nota = sc.nextDouble();
                sc.nextLine(); // limpiar buffer
                if (nota >= 0 && nota <= 10) {
                    valido = true;
                } else {
                    System.out.println("⚠️ La nota debe estar entre 0 y 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("⚠️ Error: introduce un número válido.");
                sc.nextLine(); // limpiar buffer
            }
        }

        return nota;
    }

    public static String pideTexto(String mensaje) {
        String texto;
        boolean valido = false;

        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                valido = true;
            } else {
                System.out.println("⚠️ Solo se permiten letras y espacios.");
            }
        } while (!valido);

        return texto;
    }

    // -----------------------------------------------------
    // MÉTODOS DE LÓGICA
    // -----------------------------------------------------

    public static double calculaMediaAlumno(String nombre) {
        double suma = 0.0;
        int numNotas = 3;

        System.out.println("Introduce las " + numNotas + " notas de " + nombre + ":");

        for (int i = 1; i <= numNotas; i++) {
            double nota = pideNota("   Nota " + i + ": ");
            suma += nota;
        }

        double media = suma / numNotas;
        System.out.printf("📊 Media de %s: %.2f -> %s%n",
                nombre, media, (media >= 5 ? "✅ Aprobado" : "❌ Suspenso"));
        return media;
    }

    public static boolean preguntarContinuar() {
        String respuesta;
        do {
            System.out.print("\n¿Deseas introducir otro alumno? (s/n): ");
            respuesta = sc.nextLine().toLowerCase();
        } while (!respuesta.equals("s") && !respuesta.equals("n"));

        return respuesta.equals("s");
    }

    // -----------------------------------------------------
    // MÉTODOS DE SALIDA DE RESULTADOS
    // -----------------------------------------------------

    public static void mostrarResultados(ArrayList<String> nombres, ArrayList<Double> medias) {
        System.out.println("\n==============================");
        System.out.println("📋 RESUMEN FINAL DEL GRUPO");
        System.out.println("==============================");

        int aprobados = 0;
        int suspensos = 0;
        double sumaMedias = 0;
        double maxMedia = -1;
        double minMedia = 11;
        String mejorAlumno = "";
        String peorAlumno = "";

        for (int i = 0; i < nombres.size(); i++) {
            double media = medias.get(i);
            String nombre = nombres.get(i);

            System.out.printf("%-15s -> Media: %.2f %s%n",
                    nombre, media, (media >= 5 ? "✅" : "❌"));

            sumaMedias += media;

            if (media >= 5) aprobados++;
            else suspensos++;

            if (media > maxMedia) {
                maxMedia = media;
                mejorAlumno = nombre;
            }

            if (media < minMedia) {
                minMedia = media;
                peorAlumno = nombre;
            }
        }

        double mediaGrupo = sumaMedias / nombres.size();

        System.out.println("------------------------------");
        System.out.printf("📈 Media del grupo: %.2f%n", mediaGrupo);
        System.out.println("✅ Aprobados: " + aprobados);
        System.out.println("❌ Suspensos: " + suspensos);
        System.out.println("🏆 Mejor alumno: " + mejorAlumno + " (" + String.format("%.2f", maxMedia) + ")");
        System.out.println("💀 Peor alumno: " + peorAlumno + " (" + String.format("%.2f", minMedia) + ")");
        System.out.println("==============================");
    }
}
