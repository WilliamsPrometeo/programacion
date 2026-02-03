package primera_evaluacion.ciudad.tienda.clases;

/**
 * Clase Producto
 * Utilizada como clave para Map
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Producto producto = (Producto) o;

        return this.nombre != null ? this.nombre.equals(producto.nombre) : producto.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.format("Producto: %s, precio: %.2f", nombre, precio);
    }
}
