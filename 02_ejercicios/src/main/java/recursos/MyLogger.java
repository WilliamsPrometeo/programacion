package recursos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

    private static final String CARPETA_LOGS = "logs";

    public static void logError(String nombreClase, String mensajeError, Exception e) {

        if (comprobarDirectorio(CARPETA_LOGS)) {

            String fecha = LocalDate.now().toString();
            String nombreArchivo = "log_" + fecha + "_" + nombreClase + ".txt";

            File archivo = new File(CARPETA_LOGS + File.separator + nombreArchivo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                bw.write("[" + hora + "] ERROR: " + mensajeError + "\n");
                bw.newLine();

                if (e != null) {
                    bw.write(e.getMessage());
                    bw.newLine();
                }

                bw.write("------------------------------------------------------");
                bw.newLine();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public static void logInfo(String nombreClase, String mensaje) {

        if (comprobarDirectorio(CARPETA_LOGS)) {
            String fecha = LocalDate.now().toString();
            String nombreArchivo = "log_" + fecha + "_" + nombreClase + ".txt";

            File archivo = new File(CARPETA_LOGS + File.separator + nombreArchivo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
                String hora = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

                bw.write("[" + hora + "] INFO: " + mensaje + "\n");
                bw.newLine();

                bw.write("------------------------------------------------------");
                bw.newLine();

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
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
