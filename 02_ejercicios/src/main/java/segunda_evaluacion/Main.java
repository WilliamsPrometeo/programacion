package segunda_evaluacion;

import ciudad.clases.Persona;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final String RUTA = "02_ejercicios/datos/";

    public static void main(String[] args) {

        Utilidades.listarDirectorios(RUTA);


//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd-HHmm");
//        String fecha_formateada = now.format(formatter);
//        String ruta = fecha_formateada + ".txt";
//
//        if (Utilidades.existeArchivo(ruta)) {
//            System.out.println("No te puedes quejar tanto, espera un minuto");
//        } else {
//            Utilidades.crearArchivoTexto(ruta, pedirDatos());
//
//            System.out.println("Tu queja tiene " + contarCaracteres(ruta) + " caracteres.");
//        }

    }



    public static String pedirDatos() {
        return sc.pideTexto("Ingrese el mensaje que desee enviar: ");
    }

    public static int contarCaracteres(String ruta) {
        int contador = 0;

        try (FileReader fr = new FileReader(RUTA + ruta)) {

            int caracter;
            while ((caracter = fr.read()) != -1) {
                if (Character.isLetter(caracter)) {
                    contador++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            return -1;
        }

        return contador;
    }

}
