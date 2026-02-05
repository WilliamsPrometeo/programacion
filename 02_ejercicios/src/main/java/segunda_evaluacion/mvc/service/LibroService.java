package segunda_evaluacion.mvc.service;

import segunda_evaluacion.mvc.dao.LibroDAO;
import segunda_evaluacion.mvc.dao.PrestamosDAO;
import segunda_evaluacion.mvc.exceptions.InvalidException;
import segunda_evaluacion.mvc.models.Libro;
import segunda_evaluacion.mvc.models.enums.Genero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LibroService {

    private ArrayList<Libro> libros;
    private Map<Libro, Integer> stock;

    private final LibroDAO libroDAO = new LibroDAO();
    private final PrestamosDAO prestamosDAO = new PrestamosDAO();

    public LibroService() {
        libros = libroDAO.recuperarLibros();
        stock = libroDAO.recuperarStock();
    }

    public Map<Libro, Integer> obtenerInventario() {
        return Map.copyOf(stock);
    }

    public void agregarLibro(String isbn, String titulo, String autor, Genero genero, LocalDate fecha, int stockInicial) {
        Libro libro = new Libro(isbn, titulo, autor, genero, fecha);
        libros.add(libro);
        stock.put(libro, stockInicial);
    }

    public void prestarLibro(String isbn) throws InvalidException {
        Libro libro = getLibro(isbn);
        if (libro == null){
            throw new InvalidException("Libro no encontrado.");
        }
        int nuevoStock = stock.get(libro) - 1;
        if (nuevoStock < 0) {
            throw new InvalidException("No hay stock suficiente del libro a prestar.");
        }
        stock.put(libro, nuevoStock);
        prestamosDAO.registrarPrestamo(libro);
    }

    public void actualizarStock(String isbn, int stock_nuevo) throws InvalidException {
        Libro libro = getLibro(isbn);
        if (libro == null){
            throw new InvalidException("Libro no encontrado");
        }
        if (stock_nuevo < 0) {
            throw new InvalidException("El stock no puede ser negativo.");
        }
        stock.put(libro, stock_nuevo);
    }

    public void guardar() {
        libroDAO.guardarLibros(libros);
        libroDAO.guardarStock(stock);
    }

    public Libro getLibro(String isbn){
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public boolean existeLibro(String isbn){
        return getLibro(isbn) != null;
    }
}
