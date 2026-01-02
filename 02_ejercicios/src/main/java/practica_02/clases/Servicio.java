package practica_02.clases;

import practica_02.enums.TipoServicio;

/**
 * Clase que representa un servicio realizado en el taller.
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Servicio {

    private String descripcion;
    private String mecanico;
    private TipoServicio tipo;

    /**
     * Constructor con parámetros.
     *
     * @param descripcion Descripción del servicio.
     * @param mecanico Nombre del mecánico responsable.
     * @param tipo Tipo de servicio.
     */
    public Servicio(String descripcion, String mecanico, TipoServicio tipo) {
        this.descripcion = descripcion;
        this.mecanico = mecanico;
        this.tipo = tipo;
    }

    /**
     * Obtiene la descripción del servicio.
     *
     * @return descripción del servicio.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del servicio.
     *
     * @param descripcion nueva descripción del servicio.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el nombre del mecánico responsable.
     *
     * @return nombre del mecánico.
     */
    public String getMecanico() {
        return mecanico;
    }

    /**
     * Establece el nombre del mecánico responsable.
     *
     * @param mecanico nuevo nombre del mecánico.
     */
    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    /**
     * Obtiene el tipo de servicio.
     *
     * @return tipo de servicio.
     */
    public TipoServicio getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de servicio.
     *
     * @param tipo nuevo tipo de servicio.
     */
    public void setTipo(TipoServicio tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en forma de cadena del servicio.
     *
     * @return información del servicio formateada.
     */
    @Override
    public String toString() {
        return String.format(
                "Descripción: %s | Mecánico: %s | Tipo: %s",
                this.descripcion,
                this.mecanico,
                this.tipo
        );
    }
}
