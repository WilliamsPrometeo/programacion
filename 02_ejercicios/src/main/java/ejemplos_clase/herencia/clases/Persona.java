package ejemplos_clase.herencia.clases;

import java.util.ArrayList;

/**
 * Clase Persona
 * @author Profesor - Williams
 * @version 1.0
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Vehiculo> vehiculos;

    public Persona() {
        vehiculos = new ArrayList<>();
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.vehiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return String.format("Datos de la persona: %s, %s, %d", this.nombre, this.apellido, this.edad);
    }
}
