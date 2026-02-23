package ampliacion.segunda_evaluacion;

import ampliacion.segunda_evaluacion.enums.Genero;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class Persona {
    private String dni;
    private  String nombre;
    private String apellido;
    private Genero genero;
    private LocalDate fechaNacimiento;
    private ArrayList<String> lista;

    public Persona(String dni, String nombre, String apellido, Genero genero, LocalDate fechaNacimiento, ArrayList<String> lista) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.lista = lista;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<String> getLista() {
        return lista;
    }

    public void setLista(ArrayList<String> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", genero=" + genero +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;

        Persona persona = (Persona) obj;

        return this.dni != null ? this.dni.equals(persona.dni) : persona.dni == null;
    }

    @Override
    public int hashCode() {
        return dni != null ? dni.hashCode() : 0;
    }
}
