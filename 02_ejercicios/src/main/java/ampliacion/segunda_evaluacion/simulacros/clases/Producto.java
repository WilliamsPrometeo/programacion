package ampliacion.segunda_evaluacion.simulacros.clases;

import java.io.Serializable;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;

    public Producto(int codigo, String nombre, String descripcion, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return String.format("Producto: %d, %s,\n\tDescripcion: %s | Precio: %.2f", codigo, nombre, descripcion, precio);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Producto producto = (Producto) obj;

        String codigo = String.valueOf(producto.getCodigo());

        return codigo != null ? codigo.equals(String.valueOf(producto.codigo)) :  String.valueOf(producto.codigo) == null;
    }

    @Override
    public int hashCode() {
        return String.valueOf(codigo) != null ? String.valueOf(codigo).hashCode() : 0;
    }
}
