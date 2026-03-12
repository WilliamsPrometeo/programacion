package simulacros.simulacro_daw.persistence;

import recursos.Utilidades;
import simulacros.simulacro_daw.exceptions.BibliotecaException;
import simulacros.simulacro_daw.models.Libro;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaDAO {

    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Biblioteca";
    private final File FILE = new File(RUTA + File.separator + "libros.txt");

    public void guardar(ArrayList<Libro> libros) {
        if (comprobarDirectorio(RUTA)) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
                for (Libro libro : libros) {
                    String linea =
                            libro.getCodigo() + ";" +
                                    libro.getTitulo() + ";" +
                                    libro.getAutor();
                    bw.write(linea);
                    bw.newLine();
                }
                System.out.println("Biblioteca guardada exitosamente");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public ArrayList<Libro> cargar() {
        ArrayList<Libro> libros = new ArrayList<>();
        if (FILE.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    String codigo = datos[0];
                    String titulo = datos[1];
                    String autor = datos[2];
                    libros.add(new Libro(codigo, titulo, autor));
                }
                System.out.println("Biblioteca cargada exitosamente");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return libros;
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}
