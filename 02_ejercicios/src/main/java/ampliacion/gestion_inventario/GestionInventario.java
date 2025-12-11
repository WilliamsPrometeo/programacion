package ampliacion.gestion_inventario;

import ampliacion.gestion_inventario.exceptions.CodigoInvalidoException;
import ampliacion.gestion_inventario.exceptions.PrecioValidoException;
import ampliacion.gestion_inventario.exceptions.ProductoNoEncontradoException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionInventario {

    private static final Scanner sc = new Scanner(System.in);
    private static Map<String, Double> inventario = new HashMap<String, Double>();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Metodo que muestra el menu principal
     */
    public static void menu() {
        int opcion;
        do {
            System.out.println("==== GESTIÓN DE INVENTARIO ====");
            System.out.println("1. Añadir producto" +
                    "\n2. Buscar producto" +
                    "\n3. Actualizar precio" +
                    "\n4. Mostrar inventario" +
                    "\n5. Salir" +
                    "\nOpcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    addProducto();
                    break;
                case 2:
                    try {
                        buscarProducto();
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        actualizarPrecio();
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    System.out.println("... Saliendo ...");
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }

        } while (opcion != 5);
    }

    /**
     * Metodo para añadir producto con validaciones
     */
    public static void addProducto() {
        System.out.println("Introduce el nombre del producto: ");
        String codigo = sc.nextLine();
        System.out.println("Introduce el precio del producto: ");
        double precio = sc.nextDouble();
        try {
            validarCodigo(codigo);
            validarPrecio(precio);
            inventario.put(codigo, precio);
        } catch (CodigoInvalidoException | PrecioValidoException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Metodo para validar el código del producto
     * @param codigo
     * @throws CodigoInvalidoException se lanza si el codigo esta mal
     */
    public static void validarCodigo(String codigo) throws CodigoInvalidoException {
        if (codigo.length() >= 3 && codigo.matches("[A-Z0-9]+")) {
            System.out.println("Codigo valido");
        } else {
            throw new CodigoInvalidoException("Codigo invalido");
        }

    }

    /**
     * Metodo para validar el precio del producto
     * @param precio
     * @throws PrecioValidoException se lanza si el precio esta mal
     */
    public static void validarPrecio(double precio) throws PrecioValidoException {
        if (precio >= 0) {
            System.out.println("Precio valido");
        } else {
            throw new PrecioValidoException("El precio no puede ser negativo");
        }
    }

    /**
     * Metodo para buscar productos por código
     * @throws ProductoNoEncontradoException se lanza si el código no existe en el Map
     */
    public static void buscarProducto() throws ProductoNoEncontradoException {
        System.out.println("Introduce el nombre del producto: ");
        String codigo = sc.nextLine();
        if (inventario.containsKey(codigo)) {
            System.out.printf("El precio del producto %s: %.2f ", codigo, inventario.get(codigo));
        } else {
            throw new ProductoNoEncontradoException("El producto no existe");
        }
    }

    /**
     * Metodo para actualizar el precio del producto por código
     * @throws ProductoNoEncontradoException se lanza si el código no existe en el Map
     */
    public static void actualizarPrecio() throws ProductoNoEncontradoException {
        System.out.println("Introduce el nombre del producto: ");
        String codigo = sc.nextLine();
        if (inventario.containsKey(codigo)) {
            System.out.println("Introduce el precio del producto: ");
            double precio = sc.nextDouble();
            try {
                validarPrecio(precio);
                inventario.put(codigo, precio);
            } catch (PrecioValidoException e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new ProductoNoEncontradoException("El producto no existe.");
        }
    }

    /**
     * Metodo para mostrar el inventario
     */
    public static void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario esta vacio");
        } else {
            for (String key : inventario.keySet()) {
                System.out.printf("Código: %s | Precio: %.2f%n", key, inventario.get(key));
            }
        }
    }
}
