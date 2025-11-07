package ejemplos_clase.herencia.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Clase Cliente que hereda de la clase Persona
 * @see Persona
 * @author Profesor - Williams
 * @version 1.0
 */
public class Cliente extends Persona {
    private int num_cliente;
    private LocalDateTime fecha_alta;
    private ArrayList<LocalDateTime> compras;

    public Cliente(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.fecha_alta = LocalDateTime.now();
        this.compras = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, int edad, int num_cliente) {
        super(nombre, apellido, edad);
        this.num_cliente = num_cliente;
        this.fecha_alta = LocalDateTime.now();
        this.compras = new ArrayList<>();
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public ArrayList<LocalDateTime> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<LocalDateTime> compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Cliente: %s, %s, %d, %d, %s", super.getNombre(), super.getApellido(), super.getEdad(), this.num_cliente, fecha_formateada);
    }
}
