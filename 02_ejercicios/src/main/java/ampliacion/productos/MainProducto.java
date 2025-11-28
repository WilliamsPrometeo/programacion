package ampliacion.productos;

import ampliacion.productos.clases.Producto;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainProducto {

    private static final MyScanner scanner = new MyScanner();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static final int cantidad = 2;

    public static void main(String[] args) {
        pedirProductos();
        Map<String, Producto> mapa = new HashMap<>();
        for (Producto producto : productos) {
            mapa.put(producto.getNombre(), producto);
        }

        for (String key : mapa.keySet()) {
            System.out.println(mapa.get(key));
        }

        String clave = scanner.pedirSoloTexto("Ingrese el nombre del producto: ");
        boolean existe = mapa.containsKey(clave);
        if (existe) {
            Producto producto = mapa.get(clave);
            producto.setStock(scanner.pedirNumero("Ingrese el nuevo stock del producto: "));
        } else {
            System.out.println("No existe el producto dentro del mapa");
        }

        for (String key : mapa.keySet()) {
            System.out.println(mapa.get(key));
        }

    }

    public static Producto addProducto() {
        String nombre = scanner.pedirSoloTexto("Introduce el nombre del producto: ");
        double precio = scanner.pedirDecimal("Introduce el precio del producto: ");
        int stock = scanner.pedirNumero("Introduce el stock del producto: ");

        return new Producto(nombre, precio, stock);
    }

    public static void pedirProductos() {
        for (int i = 0; i < cantidad; i++) {
            productos.add(addProducto());
        }
    }
}
