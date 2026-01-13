package segunda_evaluacion;

import recursos.MyScanner;

import java.io.*;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final String RUTA = "02_ejercicios/datos/";

    public static void main(String[] args) {

        File origen = new File(RUTA + "images.jpg");
        File destino = new File(RUTA + "otra.jpg");

        if(!origen.exists()) {
            System.out.println("El archivo no existe");
        } else {
            copiar_archivo(origen, destino);
        }

        File origenTexto = new File(RUTA + "texto.txt");
        File destinoTexto = new File(RUTA + "copia.txt");

        if (!origenTexto.exists()) {
            System.out.println("El archivo no existe");
        } else {
            copiarTexto(origenTexto, destinoTexto);
        }

    }

    private static void copiar_archivo(File origen, File destino) {
        try (
                FileInputStream fis = new FileInputStream(origen);
                FileOutputStream fos = new FileOutputStream(destino);
        ) {
            int bytes;
            while ((bytes = fis.read()) != -1) {
                fos.write(bytes);
            }

            System.out.println("Archivo copiado correctamente");
        } catch (IOException e) {
            System.out.println("ERROR " + e.getMessage());
        }
    }

    public static void copiarTexto(File origen, File destino) {

        try (
                FileReader fr = new FileReader(origen);
                FileWriter fw = new FileWriter(destino)
        ) {
            int caracter;
            while ((caracter = fr.read()) != -1) {
                fw.write(caracter);
            }

            System.out.println("Texto copiado correctamente.");

        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
