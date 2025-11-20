package ejemplos_clase.herencia.banco.clases;

import ejemplos_clase.herencia.banco.enums.TipoBanco;
import ejemplos_clase.herencia.concesionario.clases.Empleado;

import java.util.ArrayList;

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
