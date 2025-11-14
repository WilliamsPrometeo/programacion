package ejemplos_clase.herencia.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Clase Factura
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Factura {
    private int num_factura;
    private int num_cliente;
    private int num_empleado;
    private LocalDateTime fecha_creacion;
    private Vehiculo vehiculo;

    public Factura(int num_factura, int num_cliente, int num_empleado, Vehiculo vehiculo) {
        this.num_factura = num_factura;
        this.num_cliente = num_cliente;
        this.num_empleado = num_empleado;
        this.fecha_creacion = LocalDateTime.now();
        this.vehiculo = vehiculo;
    }

    public int getNum_factura() {
        return num_factura;
    }

    public void setNum_factura(int num_factura) {
        this.num_factura = num_factura;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public int getNum_empleado() {
        return num_empleado;
    }

    public void setNum_empleado(int num_empleado) {
        this.num_empleado = num_empleado;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_creacion().format(formatter);
        String datos_vehiculo = getVehiculo().toString();
        return String.format("Factura: %d, %d, %d, %8s, %s",  num_factura, num_cliente, num_empleado, fecha_formateada,  datos_vehiculo);
    }
}
