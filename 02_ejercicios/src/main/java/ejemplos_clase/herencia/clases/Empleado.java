package ejemplos_clase.herencia.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Empleado que hereda de la clase Persona
 * @see Persona
 * @author Profesor - Williams
 * @version 1.0
 */
public class Empleado extends Persona {
    private int num_empleado;
    private LocalDateTime fecha_alta;

    public Empleado(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.fecha_alta = LocalDateTime.now();
    }

    public Empleado(String nombre, String apellido, int edad, int num_empleado) {
        super(nombre, apellido, edad);
        this.num_empleado = num_empleado;
        this.fecha_alta = LocalDateTime.now();
    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Empleado: %s, %s, %d, %d, %s", super.getNombre(), super.getApellido(), super.getEdad(), this.num_empleado, fecha_formateada);
    }
}
