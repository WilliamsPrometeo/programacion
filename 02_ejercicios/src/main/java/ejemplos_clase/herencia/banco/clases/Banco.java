package ejemplos_clase.herencia.banco.clases;

import ejemplos_clase.herencia.banco.enums.TipoBanco;
import ejemplos_clase.herencia.concesionario.clases.Cliente;

import java.util.ArrayList;

/**
 * Clase Banco
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Banco {
    private TipoBanco tipo;
    private ArrayList<Cliente> clientes;
    private ArrayList<EmpleadoBanco> empleados;

    public Banco(TipoBanco tipo) {
        this.tipo = tipo;
        this.clientes = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    public TipoBanco getTipo() {
        return tipo;
    }

    public void setTipo(TipoBanco tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<EmpleadoBanco> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<EmpleadoBanco> empleados) {
        this.empleados = empleados;
    }

    public String mostarCliente(Cliente cliente) {
        StringBuilder mensaje = new StringBuilder();
        for (Cliente c : clientes) {
            mensaje.append(c.toString());
        }
        return mensaje.toString();
    }

    public String mostarEmpleado(EmpleadoBanco empleado) {
        StringBuilder mensaje = new StringBuilder();
        for (EmpleadoBanco e : empleados) {
            mensaje.append(e.toString());
        }
        return mensaje.toString();
    }

    @Override
    public String toString() {
        return String.format("Banco: %s", this.tipo);
    }
}
