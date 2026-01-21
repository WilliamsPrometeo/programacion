package segunda_evaluacion.libreria;

import recursos.MyScanner;
import recursos.Utilidades;
import segunda_evaluacion.libreria.clases.Libro;
import segunda_evaluacion.libreria.clases.enums.Genero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionLibreria {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static Map<Libro, Integer> stock = new LinkedHashMap<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION LIBRERIA =====" +
                    "\n1. Agregar libro" +
                    "\n2. Mostrar libros" +
                    "\n3. Gestionar stock libros" +
                    "\n4. Prestar libro" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    mostrarLibros();
                    break;
                case 3:
                    gestionarStock();
                    break;
                case 4:
                    prestarLibro();
                    break;
                case 5:
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }

    public static void agregarLibro() {
        String isbn;
        do {
            isbn = sc.pideTexto("Introduce el ISBN (3 letras y 2 números): ").toUpperCase();
        } while (!validarIsbn(isbn));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String autor = sc.pideTexto("Introduce el autor: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        String fecha_publicacion =  sc.pideTexto("Introduce la fecha publicacion (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(fecha_publicacion);

        Libro libro = new Libro(isbn, titulo, autor, genero, fecha);

        if (stock.containsKey(libro)) {
            System.out.println("❌ El libro ya existe!");
            return;
        }

        libros.add(libro);
        System.out.println("✅ El libro ha sido agregado exitosamente!");

        int stock_libro = sc.pedirNumero("Introduce el stock que desea agregar: ");
        stock.put(libro, stock_libro);
    }

    public static boolean validarIsbn(String isbn) {

        String validadores = "^[A-Z]{3}[0-9]{2}$";

        if (!isbn.matches(validadores)) {
            System.out.println("❌ ISBN incorrecto. Ejemplo válido: ABC12");
            return false;
        }
        return true;
    }

    public static void mostrarLibros() {

        if (!libros.isEmpty()) {
            for (Libro libro : libros) {
                System.out.println(libro);
                System.out.println("Stock: " + stock.get(libro));
                System.out.println("------------------------");
            }
        } else {
            System.out.println("No hay libros que mostrar.");
        }
    }

    public static void gestionarStock() {
        String isbn = sc.pideTexto("Introduce el ISBN: ").toUpperCase();
        Libro libro = getLibro(isbn);
        if (libro != null) {
            int nuevo_stock = sc.pedirNumero("Introduce el nuevo stock del libro " + libro.getTitulo() + ": ");
            if (nuevo_stock > 0) {
                stock.put(libro, nuevo_stock);
                System.out.println("✅ Stock actualizado exitosamente!");
            } else {
                System.out.println("El stock no puede ser un valor negativo!");
            }
        } else {
            System.out.println("❌ El libro no existe con el ISBN dado!");
        }

    }

    public static Libro getLibro(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public static void prestarLibro() {
        String isbn = sc.pideTexto("Introduce el ISBN: ").toUpperCase();
        Libro libro = getLibro(isbn);
        if (libro != null) {
            stock.put(libro, stock.get(libro) - 1);
            registrarPrestamo(libro);
            System.out.println("✅ Libro prestado exitosamente!");
        } else {
            System.out.println("❌ El libro no existe con el ISBN dado!");
        }
    }

    public static void registrarPrestamo(Libro libro) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "prestamos.txt");

            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- PRESTAMO -----\n");
                fw.write("Fecha prestamo: " + LocalDate.now() + "\n");
                fw.write("Libro:\n");
                fw.write("\tISBN: " + libro.getIsbn() + "\n");
                fw.write("\tTitulo: " + libro.getTitulo() + "\n");
                fw.write("\tAutor: " + libro.getAutor() + "\n");
                fw.write("-----------------------");

            } catch (IOException e) {
                System.out.println("Error al registrar el prestamo. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }

    public static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}
