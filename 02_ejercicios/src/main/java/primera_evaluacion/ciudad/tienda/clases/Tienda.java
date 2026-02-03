package primera_evaluacion.ciudad.tienda.clases;

import java.util.ArrayList;

/**
 * Clase Tienda
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class Tienda {
    private String nombre;
    private ArrayList<Producto> productos;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return String.format("Tienda %s, %nProductos: {%s}]", nombre, productos);
    }
}
