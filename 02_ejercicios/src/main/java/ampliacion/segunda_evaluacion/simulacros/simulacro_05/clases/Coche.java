package ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases;

public class Coche extends Vehiculo{

    private int numeroPuertas;

    public Coche(String matricula, String marca, String modelo, double precio, int numeroPuertas) {
        super(matricula, marca, modelo, precio);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Coche: %s, %s, %s, %.2f, %d",
                super.getMatricula(),
                super.getMarca(),
                super.getModelo(),
                super.getPrecio(),
                this.getNumeroPuertas());
    }
}
