package ejercicios.gestion_parking.clases;

public class Vehiculos {
    private static int contador = 1;
    private int id;
    private String matricula;
    private String marca;

    public Vehiculos() {
        this.id = contador++;
    }

    public Vehiculos(String matricula, String marca) {
        this.id = contador++;
        this.matricula = matricula;
        this.marca = marca;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return String.format("Vehiculo %d: %nMatricula: %10s, Marca: %8s", id, matricula, marca);
    }
}
