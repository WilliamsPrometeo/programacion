package ciudad.clases;

import ciudad.banco.clases.Cuenta;
import ciudad.concesionario.clases.Vehiculo;

import java.util.ArrayList;

/**
 * Clase Persona
 *
 * @author Profesor - Williams
 * @version 1.2
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Vehiculo> vehiculos;
    private Cuenta cuenta;

    /**
     * Constructor vacio de la clase Persona
     * Se inicializa la lista de vehiculos
     * Se inicializa a nulo la cuenta
     */
    public Persona() {
        vehiculos = new ArrayList<>();
        cuenta = null;
    }

    /**
     * Constructor principal de la clase Persona
     * Se inicializa la lista de vehiculos
     * Se inicializa a nulo la cuenta
     *
     * @param nombre   Nombre de la persona
     * @param apellido Apellido de la persona
     * @param edad     Edad de la persona
     */
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.vehiculos = new ArrayList<>();
        cuenta = null;
    }

    /**
     * Getter del atributo Nombre
     *
     * @return el nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Setter del atribtuo Nombre
     *
     * @param nombre estable el nombre de la persona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Getter del atributo Apellido
     *
     * @return el apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Setter del atributo Apellido
     *
     * @param apellido establece el apellido de la persona
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Getter del atributo Edad
     *
     * @return la edad de la persona
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Setter del atributo Edad
     *
     * @param edad establece la edad de la persona
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Getter del atributo vehiculos
     *
     * @return la lista de vehiculos de la persona
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del atributo vehiculos
     *
     * @param vehiculos establece la lista de vehiculos de la persona
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Metodo para añadir un Vehículo a la lista de Vehículos de la persona
     *
     * @param vehiculo vehiculo añadido
     */
    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    /**
     * Metodo toString para mostrar los datos de la persona
     *
     * @return texto formateado con los datos de la persona
     */
    @Override
    public String toString() {
        return String.format("Datos de la persona: %s, %s, %d", this.nombre, this.apellido, this.edad);
    }
}
