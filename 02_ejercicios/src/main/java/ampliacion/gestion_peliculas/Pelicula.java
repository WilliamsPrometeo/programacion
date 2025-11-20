package ampliacion.gestion_peliculas;

/**
 * Clase Pelicula
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Pelicula {
    //Atributos privados
    private String titulo;
    private String director;
    private int duracion;

    //Constructores

    /**
     * Constructor principal de la clase Pelicula
     *
     * @param titulo establece el título de la pelicula
     * @param director establece el director de la pelicula
     * @param duracion establece la duracion en minutos de la pelicula
     */
    public Pelicula(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    //Getters y Setters

    /**
     * Getter del atributo titulo
     *
     * @return el titulo de la pelicula
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del atributo titulo
     *
     * @param titulo establece el titulo de la pelicula
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del atributo director
     *
     * @return el nombre del director de la pelicula
     */
    public String getDirector() {
        return director;
    }

    /**
     * Setter del atributo director
     *
     * @param director establece el nombre del director de la pelicula
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Getter del atributo duracion
     *
     * @return los minutos de duracion de la pelicula
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Setter del atributo duracion
     *
     * @param duracion establece la duracion en minutos de la pelicula
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    //Metodo toString

    /**
     * Metodo para mostrar los datos de la pelicula
     *
     * @return texto formateado con los datos de la pelicula
     */
    @Override
    public String toString() {
        return String.format("Título: %s | Director: %s | Duracion: %d min", titulo, director, duracion);
    }
}
