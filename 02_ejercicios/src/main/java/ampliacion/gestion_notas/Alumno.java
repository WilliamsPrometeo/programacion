package ampliacion.gestion_notas;

import java.util.ArrayList;

/**
 * Clase Alumno
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Alumno {
    private String nombre;
    private ArrayList<Double> notas;

    /**
     * Constructor vacio de la clase Alumno
     */
    public Alumno() {
    }

    /**
     * Getter del atributo nombre
     * @return el nombre del Alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atributo nombre
     *
     * @param nombre establece el nombre del alumno
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo notas
     *
     * @return la lista de notas del alumno
     */
    public ArrayList<Double> getNotas() {
        return notas;
    }

    /**
     * Setter del atributo notas
     *
     * @param notas establece la lista de notas del alumno
     */
    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    /**
     * Metodo para calcular la media de notas del alumno
     *
     * @return la media de las notas del alumno
     */
    public double calcularMedia() {
        double media = 0;
        for (Double nota : notas) {
            media += nota;
        }
        media = media / notas.size();
        return media;
    }

    /**
     * Metodo que muestra los datos del alumno
     *
     * @return los datos del alumno
     */
    public String mostrarDatos() {
        String aprobado;
        if (calcularMedia() >= 5) {
            aprobado = "Aprobado";
        } else {
            aprobado = "Suspenso";
        }
        return "Nombre: " + getNombre() +
                "\nNotas: " + getNotas() +
                "\nMedia: " + calcularMedia()
                + ", " + aprobado;
    }
}
