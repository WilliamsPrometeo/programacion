package ejemplos_clase.herencia.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase Cliente que hereda de la clase Persona
 *
 * @author Profesor - Williams
 * @version 1.1
 * @see Persona
 */
public class Cliente extends Persona {
    private int num_cliente;
    private LocalDateTime fecha_alta;
    private ArrayList<Factura> compras;

    /**
     * Constructor heredado de la clase Persona
     * Inicializa el atributo de fecha_alta con la fecha del momento de la creación
     * Se inicializa la lista de compras
     *
     * @param nombre   atributo heredado
     * @param apellido atributo heredado
     * @param edad     atributo heredado
     * @see Persona
     */
    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.fecha_alta = LocalDateTime.now();
        this.compras = new ArrayList<>();
    }

    /**
     * Constructor principal de la clase Cliente
     * Inicializa el atributo de fecha_alta con la fecha del momento de la creación
     * Se inicializa la lista de compras
     *
     * @param nombre      atributo heredado
     * @param apellido    atributo heredado
     * @param edad        atributo heredado
     * @param num_cliente número de identificacion de cliente
     */
    public Cliente(String nombre, String apellido, int edad, int num_cliente) {
        super(nombre, apellido, edad);
        this.num_cliente = num_cliente;
        this.fecha_alta = LocalDateTime.now();
        this.compras = new ArrayList<>();
    }

    /**
     * Getter del atributo Num_Cliente
     *
     * @return el número identificativo del cliente
     */
    public int getNum_cliente() {
        return num_cliente;
    }

    /**
     * Setter del atributo Num_Cliente
     *
     * @param num_cliente estable el número identificativo del cliente
     */
    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    /**
     * Getter del atributo Fecha_Alta
     *
     * @return la fecha del alta del cliente
     */
    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    /**
     * Setter del atributo Fecha_Alta
     *
     * @param fecha_alta establece la fecha del alta del cliente
     */
    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * Getter del atributo Compras
     *
     * @return las lista de compras del cliente
     */
    public ArrayList<Factura> getCompras() {
        return compras;
    }

    /**
     * Setter del atributo Compras
     *
     * @param compras establece la lista de compras del cliente
     */
    public void setCompras(ArrayList<Factura> compras) {
        this.compras = compras;
    }

    /**
     * Metodo toString para mostrar los datos del cliente
     *
     * @return texto formateado con los datos del cliente
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Cliente: %s, %s, %d, %d, %s", super.getNombre(), super.getApellido(), super.getEdad(), this.num_cliente, fecha_formateada);
    }
}
