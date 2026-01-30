package segunda_evaluacion;

import ciudad.clases.Persona;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<String> lineas = new ArrayList<>();
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";

    public static void main(String[] args) {

//        boolean correcto;

        int year = sc.pedirNumero("Introduce el año: ");
        int month = 0;
        do {
            month = sc.pedirNumero("Introduce el mes: ");
        } while (!validarMes(month));
        int day = sc.pedirNumero("Introduce el dia: ");

        LocalDate fecha = LocalDate.of(year, month, day);

        System.out.println(fecha);

//        int year = fecha.getYear();
//        int mes = fecha.getMonthValue();
//        int dia = fecha.getDayOfMonth();
//
//        System.out.println(year + "-" + mes + "-" + dia);
//
//        System.out.println(fecha.getMonth());
//        System.out.println(fecha.getDayOfWeek());
//        System.out.println(fecha.getDayOfYear());
    }

    private static boolean validarMes(int month) {
        if (month < 1 || month > 12) {
            System.out.println("El mes no es valido");
            return false;
        }
        return true;
    }

    private static void guardarArchivoEnLista() {
        if (comprobarDirectorio(RUTA)) {
            File archivo = new File(RUTA + "bufferer.txt");
            if (archivo.exists()) {
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String manolo;
                    while ((manolo = br.readLine()) != null) {
                        lineas.add(manolo);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else  {
                System.out.println("El archivo no existe");
            }
        } else {
            System.out.println("Error al leer el directorio");
        }
    }

    public static void leerArchivoEnLista() {
        if (comprobarDirectorio(RUTA)) {
            File archivo = new File(RUTA + "writer.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String linea : lineas) {
                    bw.write(linea);
                    bw.newLine();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

}
