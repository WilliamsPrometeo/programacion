package ciudad.concesionario.clases;

import ciudad.concesionario.enums.Marca;

import java.time.format.DateTimeFormatter;

/**
 * Clase Moto que hereda de la clase abstracta Vehículo
 *
 * @author Profesor - Williams
 * @version 1.0
 * @see Vehiculo
 */
public class Moto extends Vehiculo {
    private int cilindrada;
    private boolean sidecar;

    /**
     * Constructor heredado de la clase Vehículo
     *
     * @param marca  atributo heredado
     * @param precio atributo heredado
     * @see Vehiculo
     */
    public Moto(Marca marca, double precio) {
        super(marca, precio);
    }

    /**
     * Constructor principal de la clase Moto
     *
     * @param marca      atributo heredado
     * @param precio     atributo heredado
     * @param cilindrada establece la cilindrada de la Moto
     * @param sidecar    ¿Tiene sidecar?
     */
    public Moto(Marca marca, double precio, int cilindrada, boolean sidecar) {
        super(marca, precio);
        this.cilindrada = cilindrada;
        this.sidecar = sidecar;
    }

    /**
     * Getter del atributo Sidecar
     *
     * @return si tiene sidecar true, sino devuelve false
     */
    public boolean isSidecar() {
        return sidecar;
    }

    /**
     * Setter del atributo Sidecar
     *
     * @param sidecar establece si tiene o no sidecar
     */
    public void setSidecar(boolean sidecar) {
        this.sidecar = sidecar;
    }

    /**
     * Getter del atributo Cilidranda
     *
     * @return el número de cilindrada de la Moto
     */
    public int getCilindrada() {
        return cilindrada;
    }

    /**
     * Setter del atributo Cilindrada
     *
     * @param cilindrada establece la cilindrada de la Moto
     */
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    /**
     * Metodo sobreescrito de la clase heredada para mostrar los datos de la Moto
     *
     * @return datos de la Moto
     */
    @Override
    public String mostrar() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = super.getFecha_matriculacion().format(formatter);
        return String.format("Moto: %s, %.2f, %d, %s", super.getMarca(), super.getPrecio(), cilindrada, fecha_formateada);
    }
}
