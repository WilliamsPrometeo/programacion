package ampliacion.segunda_evaluacion.simulacros.persistencia;

import ampliacion.segunda_evaluacion.simulacros.clases.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FicheroProducto {

    private static final String FICHERO_PRODUCTO = "producto.dat";
    private static final String FICHERO_INVENTARIO = "inventario.dat";

    public static void guardarProductos(ArrayList<Producto> productos) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO_PRODUCTO))) {
            out.writeObject(productos);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void guardarInventario(Map<Producto, Integer> inventario) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FICHERO_INVENTARIO))){
            out.writeObject(inventario);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Producto> getProductos() {
        File file = new File(FICHERO_PRODUCTO);
        ArrayList<Producto> productos = new ArrayList<>();
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                productos = (ArrayList<Producto>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return productos;
    }

    @SuppressWarnings("unchecked")
    public static Map<Producto, Integer> getInventario() {
        File file = new File(FICHERO_INVENTARIO);
        Map<Producto, Integer> inventario = new LinkedHashMap<>();
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
                inventario = (Map<Producto, Integer>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return inventario;
    }

}
