package ejemplos_clase;

import recursos.MyScanner;

import java.util.Random;

public class MainEjemplos {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

//        LocalDateTime ahora = LocalDateTime.now();
//        LocalDate ahora1 = LocalDate.now();
//        LocalTime hora1 = LocalTime.now();
//        System.out.println(ahora);
//        System.out.println(ahora1);
//        System.out.println(hora1);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formato = formatter.format(ahora);
//        String formato2 = formatter2.format(ahora1);
//        String formato3 = formatter3.format(hora1);
//        System.out.println(formato);
//        System.out.println(formato2);
//        System.out.println(formato3);

//        Random rand = new Random();
//        int alumno = rand.nextInt(28 + 1);
//        System.out.println("Alumno: " + alumno);

        Random rand = new Random();

        System.out.println("=== ASIGNACIÓN DE VALORES PARA AnalisisComplejo ===\n");

        // Asignación a 28 alumnos
        for (int i = 0; i < 28; i++) {

            // Generar número aleatorio entre 3 y 15 (ambos inclusive)
            int valorAsignado = rand.nextInt(13) + 3;

            System.out.printf("Alumno %02d → numero = %d%n", (i + 1), valorAsignado);
        }
    }

}
