package clases;

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Direccion direccion;
    private int dinero_en_banco;

    public Persona() {
        this.dinero_en_banco = 1000;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dinero_en_banco = 1000;
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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public int getDinero_en_banco() {
        return dinero_en_banco;
    }

    public void setDinero_en_banco(int dinero_en_banco) {
        this.dinero_en_banco = dinero_en_banco;
    }

    @Override
    public String toString() {
        return "Persona:\n" +
                "\tNombre: '" + nombre + "'\n" +
                "\tApellido: '" + apellido + "'\n" +
                "\tEdad: " + edad + '\n' +
                direccion + '\n' +
                "\tDinero en banco: " + dinero_en_banco;
    }
}
