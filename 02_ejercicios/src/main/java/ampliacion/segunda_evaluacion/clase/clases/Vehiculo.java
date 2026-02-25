package ampliacion.segunda_evaluacion.clase.clases;

public class Vehiculo {
    private String matricula;
    private String modelo;
    private String color;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public Vehiculo(String matricula, String modelo, String color) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Matricula %s, modelo: %s, color: %s", matricula, modelo, color);
    }

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
