package primera_evaluacion.ciudad.banco.clases;

import primera_evaluacion.ciudad.banco.enums.TipoBanco;
import primera_evaluacion.ciudad.concesionario.clases.Empleado;

public class EmpleadoBanco extends Empleado {
    private TipoBanco sucursal;

    public EmpleadoBanco(String nombre, String apellido, int edad, int num_empleado, TipoBanco sucursal) {
        super(nombre, apellido, edad, num_empleado);
        this.sucursal = sucursal;
    }

    public TipoBanco getSucursal() {
        return sucursal;
    }

    public void setSucursal(TipoBanco sucursal) {
        this.sucursal = sucursal;
    }


    @Override
    public String toString() {
        return String.format("Empleado del banco: %s | Numero de empleado: %d", getSucursal(), super.getNum_empleado());
    }
}
