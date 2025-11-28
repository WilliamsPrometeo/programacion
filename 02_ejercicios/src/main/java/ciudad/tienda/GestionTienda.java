package ciudad.tienda;

import ciudad.tienda.clases.Producto;
import ciudad.tienda.clases.StockTienda;
import ciudad.tienda.clases.Tienda;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestionTienda {

    private static final MyScanner sc = new MyScanner();
    private static final int cantidadProductos = 2;
    private static ArrayList<StockTienda> tiendas = new ArrayList<>();

    public GestionTienda() {

    }

    public ArrayList<StockTienda> getTiendas() {
        return tiendas;
    }

    public void menu() {
        boolean correcto = false;
        do {
            System.out.println("====GESTION TIENDAS====");
            int opcion = sc.pedirNumero("1. Gestionar Tiendas" +
                    "\n2. Mostrar Tiendas" +
                    "\n3. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    tiendas.add(gestionarTiendas());
                    break;
                case 2:
                    mostrarTiendas();
                    break;
                case 3:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!correcto);
    }

    private static void mostrarTiendas() {
        if (!tiendas.isEmpty()) {
            for (StockTienda tienda : tiendas) {
                System.out.println(tienda);
            }
        } else {
            System.out.println("No hay tiendas que mostrar.");
        }
    }

    private static Producto addProducto() {
        String nombre = sc.pedirSoloTexto("Nombre del producto: ");
        double precio = sc.pedirDecimal("Precio del producto: ");
        return new Producto(nombre, precio);
    }

    private static ArrayList<Producto> pedirProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i < cantidadProductos; i++) {
            productos.add(addProducto());
        }
        return productos;
    }

    private static StockTienda gestionarTiendas() {
        Tienda tienda = new Tienda(sc.pedirSoloTexto("Nombre de la tienda: "));
        tienda.setProductos(pedirProductos());

        Map<Producto, Integer> tiendaStock = new HashMap<>();
        for (Producto producto : tienda.getProductos()) {
            tiendaStock.put(producto, establecerStock(producto));
        }
        StockTienda stockTienda = new StockTienda(tienda);
        stockTienda.setStock(tiendaStock);
        return stockTienda;
    }

    private static int establecerStock(Producto producto) {
        return sc.pedirNumero("Stock del producto " + producto.getNombre() + ": ");
    }
}
