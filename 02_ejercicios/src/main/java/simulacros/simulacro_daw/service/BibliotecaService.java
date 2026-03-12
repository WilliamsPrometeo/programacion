package simulacros.simulacro_daw.service;

import simulacros.simulacro_daw.exceptions.BibliotecaException;
import simulacros.simulacro_daw.models.Libro;
import simulacros.simulacro_daw.persistence.BibliotecaDAO;

import java.util.ArrayList;

public class BibliotecaService {

    private ArrayList<Libro> libros;
    private BibliotecaDAO dao;

    public BibliotecaService() {
        libros = new ArrayList<>();
        dao = new BibliotecaDAO();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public Libro getLibro(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
    }

    public void cargar() {
        libros = dao.cargar();
    }

    public void guardar() {
        dao.guardar(libros);
    }
}
