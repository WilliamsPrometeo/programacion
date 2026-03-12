package simulacros.simulacro_daw.models;

/**
 * Clase Libro para hacer registro en una biblioteca
 * @author Profesor - Williams
 * @version 1.0
 */
public class Libro {
    private String codigo;
    private String titulo;
    private String autor;

    public Libro(String codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    @Override
    public String toString() {
        return String.format("Libro: %s - Titulo: %s - Autor: %s",
                codigo,
                titulo,
                autor);
    }
}
