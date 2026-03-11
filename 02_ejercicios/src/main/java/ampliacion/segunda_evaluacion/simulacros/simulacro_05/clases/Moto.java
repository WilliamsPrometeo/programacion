package ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases;

/**
 * Clase Moto - clase que extiende de Vehiculo
 * @see Vehiculo
 * @author Profesor - Williams
 * @version 1.0
 */
public class Moto extends Vehiculo{
    private int cilindrada;

    public Moto(String matricula, String marca, String modelo, double precio, int cilindrada) {
        super(matricula, marca, modelo, precio);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public String mostrarInformacion() {
        return String.format("Moto: %s, %s, %s, %.2f, %d",
                super.getMatricula(),
                super.getMarca(),
                super.getModelo(),
                super.getPrecio(),
                this.getCilindrada());
    }
}
