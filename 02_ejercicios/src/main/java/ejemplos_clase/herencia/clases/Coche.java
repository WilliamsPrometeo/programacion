package ejemplos_clase.herencia.clases;

import ejemplos_clase.herencia.enums.Marca;

/**
 * Clase Coche que hereda de la clase abstracta Vehículo
 * @see Vehiculo
 * @author Profesor - Williams
 * @version 1.0
 */
public class Coche extends Vehiculo {

    private int cv;

    /**
     * Construcutor principal de la clase Coche
     * @see Vehiculo
     * @param marca atributo heredado de Vehiculo
     * @param modelo atributo heredado de Vehiculo
     * @param num_ruedas atributo heredado de Vehiculo
     * @param cv numero de caballos del coche
     */
    public Coche(Marca marca, String modelo, int num_ruedas, int cv) {
        super(marca, modelo, num_ruedas);
        this.cv = cv;
    }

    /**
     * Constructor secundario de la clase Coche
     * @see Vehiculo
     * @param modelo atributo heredado de Vehiculo
     * @param num_ruedas atributo heredado de Vehiculo
     * @param cv numero de caballos del coche
     */
    public Coche(String modelo, int num_ruedas, int cv) {
        super(modelo, num_ruedas);
        this.cv = cv;
    }

    /**
     * Constructor heredado de la clase Vehiculo
     * @see Vehiculo
     * @param modelo atributo heredado de Vehiculo
     * @param num_ruedas atributo heredado de Vehiculo
     */
    public Coche(String modelo, int num_ruedas) {
        super(modelo, num_ruedas);
    }

    /**
     * Getter del atributo Cv
     * @return el número de caballos del coche
     */
    public int getCv() {
        return cv;
    }

    /**
     * Setter del atributo Cv
     * @param cv número de caballos del coche
     */
    public void setCv(int cv) {
        this.cv = cv;
    }

    /**
     * Metodo sobreescrito de la clase heredada para mostrar los datos del coche
     * @return datos del coche
     */
    @Override
    public String mostrar() {
        return "Esto es un coche: " + super.getMarca() + super.getModelo() + this.getCv();
    }

}
