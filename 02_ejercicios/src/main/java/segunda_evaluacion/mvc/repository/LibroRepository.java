package segunda_evaluacion.mvc.repository;

import segunda_evaluacion.mvc.exceptions.InvalidException;
import segunda_evaluacion.mvc.models.Libro;
import segunda_evaluacion.mvc.models.enums.Genero;

import java.time.LocalDate;
import java.util.Map;

public interface LibroRepository {
    Map<Libro, Integer> obtenerInventario();

    void agregarLibro(String isbn, String titulo, String autor, Genero genero, LocalDate fecha, int stock);

    void prestarLibro(String isbn) throws InvalidException;

    void actualizarStock(String isbn, int stock) throws InvalidException;

    void guardar();

    Libro getLibro(String isbn);

    boolean existeLibro(String isbn);
}
