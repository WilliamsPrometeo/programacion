package ejemplos_clase.tienda;

import ejemplos_clase.tienda.clases.Producto;
import recursos.MyScanner;

import java.util.ArrayList;

public class GestionTienda {

    private static final MyScanner sc =  new MyScanner();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static final int cantidadProductos = 10;

    public static void main(String[] args) {


    }

    public static Producto addProducto() {
        String nombre = sc.pedirSoloTexto("Nombre del producto: ");
        double precio = sc.pedirDecimal("Precio del producto: ");
        return new Producto(nombre, precio);
    }

    public static void pedirProductos() {
        for (int i = 0; i < cantidadProductos ; i++) {
            productos.add(addProducto());
        }
    }
}
