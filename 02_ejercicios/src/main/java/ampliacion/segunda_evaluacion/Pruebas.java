package ampliacion.segunda_evaluacion;

import ampliacion.segunda_evaluacion.enums.Genero;
import recursos.Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Pruebas {
    public static void main(String[] args) {
        String ruta = "02_ejercicios/datos_ampliacion/";

        String ruta_SO = System.getProperty("user.home") + "/Desktop/DAW/Pruebas_Ampliacion/";

        if (comprobarDirectorio(ruta_SO)) {
            File archivo = new File(ruta_SO + "textos.txt");
            try (FileWriter fw = new FileWriter(archivo, true);) {
                fw.write("Escribo encima 2\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Archivo escrito correctamente");
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
