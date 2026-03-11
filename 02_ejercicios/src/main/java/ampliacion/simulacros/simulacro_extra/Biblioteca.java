package ampliacion.simulacros.simulacro_extra;

import java.io.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {

        for (Libro l : libros) {
            if (l.getCodigo().equals(libro.getCodigo())) {
                System.out.println("Ya existe un libro con ese código.");
                return;
            }
        }

        libros.add(libro);
        System.out.println("Libro añadido correctamente.");
    }

    public void mostrarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro l : libros) {
            System.out.println(l);
        }
    }

    public void guardarEnFichero(String ruta) {

        File fichero = new File(ruta);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fichero))) {

            for (Libro l : libros) {

                String linea = l.getCodigo() + ";" +
                        l.getTitulo() + ";" +
                        l.getAutor();

                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Libros guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir el fichero.");
        }
    }

    public void cargarDesdeFichero(String ruta) {

        File fichero = new File(ruta);

        if (!fichero.exists()) {
            System.out.println("El fichero no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String codigo = datos[0];
                String titulo = datos[1];
                String autor = datos[2];

                Libro libro = new Libro(codigo, titulo, autor);

                libros.add(libro);
            }

            System.out.println("Libros cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero.");
        }
    }
}
