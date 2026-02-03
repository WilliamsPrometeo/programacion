package ampliacion.primera_evaluacion.clases;

public class Direccion {
    private String calle;
    private int cod_postal;

    public Direccion() {
    }

    public Direccion(String calle, int cod_postal) {
        this.calle = calle;
        this.cod_postal = cod_postal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(int cod_postal) {
        this.cod_postal = cod_postal;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "calle='" + calle + '\'' +
                ", cod_postal=" + cod_postal +
                '}';
    }
}
