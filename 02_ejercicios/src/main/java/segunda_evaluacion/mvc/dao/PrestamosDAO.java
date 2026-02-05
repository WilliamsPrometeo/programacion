package segunda_evaluacion.mvc.dao;

import recursos.MyLogger;
import recursos.Utilidades;
import segunda_evaluacion.mvc.models.Libro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class PrestamosDAO {

    public void registrarPrestamo(Libro libro) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/MVC/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "prestamos.txt");

            MyLogger.logInfo(this.getClass().getSimpleName(),"Inicilizando el registro del prestamo");
            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- PRESTAMO -----\n");
                fw.write("Fecha prestamo: " + LocalDate.now() + "\n");
                fw.write("Libro:\n");
                fw.write("\tISBN: " + libro.getIsbn() + "\n");
                fw.write("\tTitulo: " + libro.getTitulo() + "\n");
                fw.write("\tAutor: " + libro.getAutor() + "\n");
                fw.write("-----------------------");

                MyLogger.logInfo(this.getClass().getSimpleName(),"Prestamo registrado correctamente");
            } catch (IOException e) {
                MyLogger.logError(
                        this.getClass().getSimpleName(),
                        "Error en el registro del prestamo",
                        e
                );
                System.out.println("Error al registrar el prestamo. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
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
