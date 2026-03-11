package ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases;

/**
 * Clase abstracta Vehiculo
 * @author Profesor - Williams
 * @version 1.0
 */
public abstract class Vehiculo {

    private String matricula;
    private String marca;
    private String modelo;
    private double precio;

    public Vehiculo(String matricula, String marca, String modelo, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public abstract String mostrarInformacion();

    @Override
    public int hashCode() {
        return matricula != null ? matricula.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Vehiculo v = (Vehiculo) obj;

        return this.matricula != null ? this.matricula.equals(v.matricula) : v.matricula == null;
    }
}
