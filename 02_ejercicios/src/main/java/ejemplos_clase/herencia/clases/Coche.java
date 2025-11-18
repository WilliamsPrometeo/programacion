package ejemplos_clase.herencia.clases;

import ejemplos_clase.herencia.enums.Marca;

import java.time.format.DateTimeFormatter;

/**
 * Clase Coche que hereda de la clase abstracta Vehículo
 *
 * @author Profesor - Williams
 * @version 2.0
 * @see Vehiculo
 */
public class Coche extends Vehiculo {

    private int num_puertas;
    private boolean airbags;

    /**
     * Constructor heredado de la clase Vehiculo
     *
     * @param marca  atributo heredado
     * @param precio atributo heredado
     * @see Vehiculo
     */
    public Coche(Marca marca, double precio) {
        super(marca, precio);
    }

    /**
     * Constructor principal de la clase Coche
     *
     * @param marca       atributo heredado
     * @param precio      atributo heredado
     * @param num_puertas Numero de puertas del Coche
     * @param airbags     ¿Tiene airbags?
     */
    public Coche(Marca marca, double precio, int num_puertas, boolean airbags) {
        super(marca, precio);
        this.num_puertas = num_puertas;
        this.airbags = airbags;
    }

    /**
     * Getter del atributo Puertas
     *
     * @return Número de puertas del Coche
     */
    public int getNum_puertas() {
        return num_puertas;
    }

    /**
     * Setter del atributo Puertas
     *
     * @param num_puertas Número de puertas del Coche
     */
    public void setNum_puertas(int num_puertas) {
        this.num_puertas = num_puertas;
    }

    /**
     * Getter del atributo Airbags
     *
     * @return si tiene airbags true, sino return false
     */
    public boolean isAirbags() {
        return airbags;
    }

    /**
     * Setter del atributo Airbags
     *
     * @param airbags establece si tiene o no airbags
     */
    public void setAirbags(boolean airbags) {
        this.airbags = airbags;
    }

    /**
     * Metodo sobreescrito de la clase heredada para mostrar los datos del coche
     *
     * @return datos del coche
     */
    @Override
    public String mostrar() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = super.getFecha_matriculacion().format(formatter);
        return String.format("Coche: %s, %.2f, %d, %s", super.getMarca(), super.getPrecio(), num_puertas, fecha_formateada);
    }

}
