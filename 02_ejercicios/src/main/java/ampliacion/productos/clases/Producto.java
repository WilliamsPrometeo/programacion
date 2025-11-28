package ampliacion.productos.clases;

/**
 * Clase Producto
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Producto {
    //Atributos privados
    private String nombre;
    private double precio;
    private int stock;

    //Constructor/es
    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //Getters y Setters
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Metodos
    @Override
    public String toString() {
        return String.format("Producto: %s, precio: %.2f, stock: %d", nombre, precio, stock);
    }
}
