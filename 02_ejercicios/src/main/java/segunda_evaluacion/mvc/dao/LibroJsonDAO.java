package segunda_evaluacion.mvc.dao;

import recursos.MyLogger;
import segunda_evaluacion.mvc.models.Libro;
import segunda_evaluacion.mvc.models.enums.Genero;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibroJsonDAO {
    private static final String RUTA = "libros.json";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void guardarLibros(List<Libro> libros) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA))) {
            bw.write(listarLibroToJson(libros));
        } catch (IOException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al escribir el JSON",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    private static String listarLibroToJson(List<Libro> libros) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        for (Libro libro : libros) {
            json.append(libroToJson(libro));
            if (libros.size() > 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }

    private static String libroToJson(Libro libro) {
        return "{" +
                "\"isbn\":\"" +
                libro.getIsbn() + "\"," +
                "\"titulo\":\"" +
                libro.getTitulo() + "\"," +
                "\"autor\":\"" +
                libro.getAutor() + "\"," +
                "\"genero\":\"" +
                libro.getGenero() + "\"," +
                "\"fecha_publicacion\":\"" +
                libro.getFecha_publicacion().format(FORMATTER) + "\"" +
                "}";
    }

    public List<Libro> leerLibros() {
        File file = new File(RUTA);
        if (!file.exists()) return new ArrayList<>();

        StringBuilder json = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                json.append(linea.trim());
            }
        } catch (IOException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al leer el JSON",
                    e
            );
            System.out.println(e.getMessage());
        }
        return jsonToListaLibros(json.toString());
    }

    private static List<Libro> jsonToListaLibros(String json) {
        List<Libro> libros = new ArrayList<>();

        if (json.equals("[]") || json.isEmpty()) return libros;

        json = json.substring(1, json.length() - 1); // Quitamos [ ]
        String[] objetos = json.split("\\}, \\{");
        for (String objeto : objetos) {
            objeto = objeto.replace("{","").replace("}","");
            libros.add(jsonToLibro(objeto));
        }
        return libros;
    }

    private static Libro jsonToLibro(String json) {
        String[] campos = json.split(",");
        String isbn = "";
        String titulo = "";
        String autor = "";
        Genero genero = null;
        LocalDate fecha_publicacion = null;

        for (String campo : campos) {
            String[] claveValor = campo.split(":");
            String clave = claveValor[0].replace("\"", "");
            String valor = claveValor[1].replace("\"", "");
            switch (clave) {
                case "isbn":
                    isbn = valor;
                    break;
                case "titulo":
                    titulo = valor;
                    break;
                case "autor":
                    autor = valor;
                    break;
                case "genero":
                    genero = Genero.valueOf(valor);
                    break;
                case "fecha_publicacion":
                    fecha_publicacion = LocalDate.parse(valor, FORMATTER);
                    break;
            }
        }
        return new Libro(isbn, titulo, autor, genero, fecha_publicacion);
    }
}
