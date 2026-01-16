package segunda_evaluacion.libreria.clases;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;
    private Direccion direccion;

    public Biblioteca(String nombre, ArrayList<Libro> libros, Direccion direccion) {
        this.nombre = nombre;
        this.libros = libros;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("Biblioteca: %s, %s %n", nombre, direccion);
    }
}
