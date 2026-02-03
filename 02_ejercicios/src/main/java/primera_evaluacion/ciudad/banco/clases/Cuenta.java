package primera_evaluacion.ciudad.banco.clases;

import primera_evaluacion.ciudad.banco.enums.Divisa;

/**
 * Clase Cuenta
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Cuenta {
    private String num_cuenta;
    private double cantidad_dinero;
    private Divisa divisa;

    public Cuenta(String num_cuenta, Divisa divisa) {
        this.num_cuenta = num_cuenta;
        this.divisa = divisa;
        this.cantidad_dinero = 0;
    }

    public String getNum_cuenta() {
        return num_cuenta;
    }

    public void setNum_cuenta(String num_cuenta) {
        this.num_cuenta = num_cuenta;
    }

    public double getCantidad_dinero() {
        return cantidad_dinero;
    }

    public void setCantidad_dinero(double cantidad_dinero) {
        this.cantidad_dinero = cantidad_dinero;
    }

    public Divisa getDivisa() {
        return divisa;
    }

    public void setDivisa(Divisa divisa) {
        this.divisa = divisa;
    }

    @Override
    public String toString() {
        return String.format("Cuenta: Numero de cuenta: %s | Cantidad disponible: %.2f", num_cuenta, cantidad_dinero);
    }
}
