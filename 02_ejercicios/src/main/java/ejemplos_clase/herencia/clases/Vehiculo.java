package ejemplos_clase.herencia.clases;

import ejemplos_clase.herencia.enums.Marca;

/**
 * Clase abstracta Vehiculo, para uso de herencia
 * @author Profesor - Williams
 * @version 1.0
 */
abstract class Vehiculo {
    private Marca marca;
    private String modelo;
    private int num_ruedas;

    /**
     * Constructor principal de la clase Vehículo
     * @param marca Enumeración para establecer la marca
     * @param modelo Cadena de caracteres para contener el modelo
     * @param num_ruedas Numero de ruedas del vehiculo
     */
    public Vehiculo(Marca marca, String modelo, int num_ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.num_ruedas = num_ruedas;
    }

    /**
     * Constructor secundario de la clase Vehículo
     * @param modelo Cadena de caracteres para contener el modelo
     * @param num_ruedas Numero de ruedas del vehiculo
     */
    public Vehiculo(String modelo, int num_ruedas) {
        this.modelo = modelo;
        this.num_ruedas = num_ruedas;
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
     * Getter del atributo Modelo
     * @return el modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Setter del atributo Modelo
     * @param modelo Cadena de caracteres para contener el modelo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Getter del atributo NumRuedas
     * @return el número de ruedas
     */
    public int getNum_ruedas() {
        return num_ruedas;
    }

    /**
     * Setter del atributo NumRuedas
     * @param num_ruedas Número de ruedas del vehículo
     */
    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }

    /**
     * Metodo abstracto para mostrar los datos del vehículo
     * @return los datos del vehículo
     */
    public abstract String mostrar();
}
