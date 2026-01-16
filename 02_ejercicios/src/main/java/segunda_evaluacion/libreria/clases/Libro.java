package segunda_evaluacion.libreria.clases;

import segunda_evaluacion.libreria.clases.enums.Genero;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private Genero genero;
    private LocalDate fecha_publicacion;

    public Libro(String isbn, String titulo, String autor, Genero genero, LocalDate fecha_publicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.fecha_publicacion = fecha_publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String fecha_formateada = fecha_publicacion.format(formatter);
        return String.format("Libro: %10s | Titulo: %8s | Autor: %8s | Genero: %10s | Fecha de publicacion: %10s", isbn, titulo, autor, genero, fecha_formateada);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Libro libro = (Libro) obj;
        return this.isbn != null ? this.isbn.equals(libro.getIsbn()) : libro.getIsbn() == null;
    }

    @Override
    public int hashCode() {
        return isbn != null ? isbn.hashCode() : 0;
    }
}
