package ampliacion.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona {
    //Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;
    private LocalDateTime fecha_creacion;

    //Constructor/es

    //Constructor Vacio
    public Persona() {
    }

    //Constructor con parámetros

    public Persona(String nombre, String apellido, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.fecha_creacion = LocalDateTime.now();
    }


    //Getter y Setters

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    //toString

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion=" + direccion +
                ", fecha_nacimiento=" + fecha_creacion +
                '}';
    }


    //Métodos
}
