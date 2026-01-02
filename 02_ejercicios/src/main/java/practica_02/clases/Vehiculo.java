package practica_02.clases;

import practica_02.enums.TipoVehiculo;

/**
 * Clase que representa un vehículo del taller.
 * Cada vehículo se identifica de forma única por su matrícula.
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Vehiculo {

    private String matricula;
    private String modelo;
    private TipoVehiculo tipo;

    /**
     * Constructor con parámetros.
     *
     * @param matricula Matrícula del vehículo.
     * @param modelo Modelo del vehículo.
     * @param tipo Tipo de vehículo.
     */
    public Vehiculo(String matricula, String modelo, TipoVehiculo tipo) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    /**
     * Obtiene la matrícula del vehículo.
     *
     * @return matrícula del vehículo.
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Establece la matrícula del vehículo.
     *
     * @param matricula nueva matrícula del vehículo.
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtiene el modelo del vehículo.
     *
     * @return modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo nuevo modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene el tipo de vehículo.
     *
     * @return tipo de vehículo.
     */
    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de vehículo.
     *
     * @param tipo nuevo tipo de vehículo.
     */
    public void setTipo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    /**
     * Devuelve una representación en forma de cadena del vehículo.
     *
     * @return información del vehículo formateada.
     */
    @Override
    public String toString() {
        return String.format(
                "Matricula: %s | Modelo: %s | Tipo: %s",
                this.matricula,
                this.modelo,
                this.tipo
        );
    }

    /**
     * Genera el código hash del vehículo basado en la matrícula.
     *
     * @return código hash del vehículo.
     */
    @Override
    public int hashCode() {
        return this.matricula != null ? this.matricula.hashCode() : 0;
    }

    /**
     * Compara este vehículo con otro objeto.
     * Dos vehículos se consideran iguales si tienen la misma matrícula.
     *
     * @param o objeto a comparar.
     * @return {@code true} si ambos vehículos son iguales; {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;
        return this.matricula != null
                ? this.matricula.equals(vehiculo.matricula)
                : vehiculo.matricula == null;
    }
}
