package segunda_evaluacion;

import ciudad.clases.Persona;
import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<String> lineas = new ArrayList<>();

    public static void main(String[] args) {
        guardarArchivoEnLista();
        for (String s : lineas) {
            System.out.println("Linea: " + s);
        }
    }

    private static void guardarArchivoEnLista() {
        String  ruta = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "bufferer.txt");
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

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }

}
