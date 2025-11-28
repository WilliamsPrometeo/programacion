package ciudad.concesionario.clases;

import ciudad.concesionario.enums.Marca;

import java.time.LocalDateTime;

/**
 * Clase abstracta Vehiculo, para uso de herencia
 * @author Profesor - Williams
 * @version 2.0
 */
public abstract class Vehiculo {
    private Marca marca;
    private double precio;
    private LocalDateTime fecha_matriculacion;

    /**
     * Constructor principal de la clase Vehículo
     * Inicializa el atribtuo fecha_matricula con la fecha del momento de su creación
     * @param marca Enumeración para establecer la marca
     * @param precio Precio del Vehículo
     */
    public Vehiculo(Marca marca, double precio) {
        this.marca = marca;
        this.precio = precio;
        this.fecha_matriculacion = LocalDateTime.now();
    }

    /**
     * Getter del atributo Marca
     * @return la marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * Setter del atributo Marca
     * @param marca Enumeración para establecer la marca
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * Getter del atributo Precio
     * @return el precio del Vehiculo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter del atributo Precio
     * @param precio Precio del Vehiculo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Getter del atributo Fecha Matriculación
     * @return la fecha en la que se ha matriculado
     */
    public LocalDateTime getFecha_matriculacion() {
        return fecha_matriculacion;
    }

    /**
     * Setter del atributo Fecha Matriculación
     * @param fecha_matriculacion establece la fecha de matriculación
     */
    public void setFecha_matriculacion(LocalDateTime fecha_matriculacion) {
        this.fecha_matriculacion = fecha_matriculacion;
    }

    /**
     * Metodo abstracto para mostrar los datos del vehículo
     * @return los datos del vehículo
     */
    public abstract String mostrar();
}
