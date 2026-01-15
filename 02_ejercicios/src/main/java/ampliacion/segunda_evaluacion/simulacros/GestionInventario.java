package ampliacion.segunda_evaluacion.simulacros;

import ampliacion.segunda_evaluacion.simulacros.clases.Producto;
import ampliacion.segunda_evaluacion.simulacros.exceptions.CantidadInvalidaException;
import ampliacion.segunda_evaluacion.simulacros.exceptions.CodigoInvalidoException;
import ampliacion.segunda_evaluacion.simulacros.exceptions.PrecioInvalidoException;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionInventario {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Map<Producto, Integer> inventario = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("==== GESTION INVENTARIO ==== ");
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("1. Añadir producto" +
                    "\n2. Mostrar inventario" +
                    "\n3. Gestionar inventario" +
                    "\n4. Salir");
            switch (opcion) {
                case 1:
                    addProducto();
                    break;
                case 2:
                    mostrarInventario();
                    break;
                case 3:
                    gestionarInventario();
                    break;
                case 4:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!exit);
    }

    public static void addProducto() {
        boolean correcto;
        int codigo = 0;
        do {
            correcto = true;
            try {
                codigo = sc.pedirNumero("Introduce el codigo del producto: ");
                if (codigo < 0) {
                    throw new CodigoInvalidoException("El codigo no puede ser negativo");
                } else if (String.valueOf(codigo).length() < 3) {
                    throw new CodigoInvalidoException("El codigo tiene que tener al menos 3 digitos");
                } else {
                    for (Producto producto : productos) {
                        if (producto.getCodigo() == codigo) {
                            throw new CodigoInvalidoException("El codigo ya existe");
                        }
                    }
                }
            } catch (CodigoInvalidoException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        String nombre = sc.pedirSoloTexto("Introduce el nombre del producto: ");
        String descripcion = sc.pideTexto("Introduce el descripcion del producto: ");
        double precio = 0.0;
        do {
            correcto = true;
            try {
                precio = sc.pedirDecimal("Introduce el precio del producto: ");
                if (precio < 0) {
                    throw new PrecioInvalidoException("El precio no tiene que ser negativo");
                }
            } catch (PrecioInvalidoException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }

        } while (!correcto);

        productos.add(new Producto(codigo, nombre, descripcion, precio));

    }

    public static void mostrarInventario() {
        for(Producto producto: inventario.keySet()) {
            System.out.printf("%s - Cantidad en stock: %s\n", producto, inventario.get(producto));
        }
    }

    public static void gestionarInventario() {
        boolean correcto;
        for (Producto producto: productos) {
            int cantidad = 0;
            do {
                correcto = true;
                try {
                    System.out.println(producto);
                    cantidad = sc.pedirNumero("Introduce el cantidad del producto: ");
                    if (cantidad < 0) {
                        throw new CantidadInvalidaException("La cantidad en stock no puede ser negativa");
                    }
                } catch (CantidadInvalidaException e) {
                    System.out.println(e.getMessage());
                    correcto = false;
                }
            } while (!correcto);

            inventario.put(producto, cantidad);
        }
    }
}
