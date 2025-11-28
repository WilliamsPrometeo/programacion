package ciudad.concesionario.clases;

import ciudad.clases.Persona;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Empleado que hereda de la clase Persona
 *
 * @author Profesor - Williams
 * @version 1.0
 * @see Persona
 */
public class Empleado extends Persona {
    private int num_empleado;
    private LocalDateTime fecha_alta;

    /**
     * Constructor heredado de la clase Persona
     * Inicializamos el atributo fecha_alta con la fecha del momento de la creación
     *
     * @param nombre   atributo heredado
     * @param apellido atributo heredado
     * @param edad     atributo heredado
     * @see Persona
     */
    public Empleado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.fecha_alta = LocalDateTime.now();
    }

    /**
     * Constructor principal de la clase Empleado
     * Inicializamos el atributo fecha_alta con la fecha del momento de la creación
     *
     * @param nombre atributo heredado
     * @param apellido atributo heredado
     * @param edad atributo heredado
     * @param num_empleado número identificativo del empleado
     */
    public Empleado(String nombre, String apellido, int edad, int num_empleado) {
        super(nombre, apellido, edad);
        this.num_empleado = num_empleado;
        this.fecha_alta = LocalDateTime.now();
    }

    /**
     * Getter del atributo Num_Empleado
     *
     * @return el número identificativo del empleado
     */
    public int getNum_empleado() {
        return num_empleado;
    }

    /**
     * Setter del atributo Num_Empleado
     *
     * @param num_empleado establece el número identificativo del empleado
     */
    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    /**
     * Getter del atributo Fecha_Alta
     *
     * @return la fecha de alta del empleado
     */
    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    /**
     * Setter del atributo Fecha_Alta
     *
     * @param fecha_alta establece la fecha de alta del empleado
     */
    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    /**
     * Metodo toString para mostrar los datos del empleado
     *
     * @return texto formateado con los datos del empleado
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Empleado: %s, %s, %d, %d, %s", super.getNombre(), super.getApellido(), super.getEdad(), this.num_empleado, fecha_formateada);
    }
}
