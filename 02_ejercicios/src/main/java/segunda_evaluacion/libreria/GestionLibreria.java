package segunda_evaluacion.libreria;

import recursos.MyLogger;
import recursos.MyScanner;
import recursos.Utilidades;
import segunda_evaluacion.libreria.clases.Libro;
import segunda_evaluacion.libreria.clases.enums.Genero;
import segunda_evaluacion.libreria.exceptions.InvalidDateException;
import segunda_evaluacion.libreria.persistencia.FicheroLibro;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionLibreria {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Libro> libros;
    private static Map<Libro, Integer> stock;

    public static void main(String[] args) {
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Iniciando programa");
        menu();
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Terminando programa");
    }

    public static void init() {
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Inicializando recuperación de archivos");
        libros = FicheroLibro.recuperarLibros();
        stock = FicheroLibro.recuperarStock();
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Recuperación de archivos correctamente");
    }

    public static void menu() {
        init();
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Inicializando el menú");
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero("===== GESTION LIBRERIA =====" +
                    "\n1. Agregar libro" +
                    "\n2. Mostrar libros" +
                    "\n3. Gestionar stock libros" +
                    "\n4. Prestar libro" +
                    "\n5. Salir" +
                    "\n6. Guardar" +
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
                    guardar();
                    exit = true;
                    break;
                case 6:
                    System.out.println("Guardando ....");
                    guardar();
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }

    private static void guardar() {
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Guardando los datos en archivos");
        FicheroLibro.guardarLibros(libros);
        FicheroLibro.guardarStock(stock);
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Guardado exitosamente");
    }

    public static void agregarLibro() {
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Agregando libro");
        String isbn;
        do {
            isbn = sc.pideTexto("Introduce el ISBN (3 letras y 2 números): ").toUpperCase();
        } while (!validarIsbn(isbn));
        String titulo = sc.pideTexto("Introduce el titulo: ");
        String autor = sc.pideTexto("Introduce el autor: ");
        Genero genero = Utilidades.pedirEnum(Genero.class, "Introduce el genero: ");
        LocalDate fecha = getFecha();

        Libro libro = new Libro(isbn, titulo, autor, genero, fecha);

        if (stock.containsKey(libro)) {
            System.out.println("❌ El libro ya existe!");
            return;
        }

        libros.add(libro);
        System.out.println("✅ El libro ha sido agregado exitosamente!");
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Libro agregado correctamente");

        int stock_libro = sc.pedirNumero("Introduce el stock que desea agregar: ");
        stock.put(libro, stock_libro);
    }

    public static LocalDate getFecha() {
        boolean correcto;
        LocalDate fecha = null;
        do {
            correcto = true;
            String fecha_string = sc.pideTexto("Introduce la fecha (YYYY-MM-DD): ");
            try {
                fecha = LocalDate.parse(fecha_string);
                if (fecha.isAfter(LocalDate.now()) || fecha.getYear() < 1200) {
                    throw new InvalidDateException(fecha, 1200, LocalDate.now().getYear());
                }
            } catch (DateTimeParseException | InvalidDateException e) {
                MyLogger.logError(
                        GestionLibreria.class.getSimpleName(),
                        "Error en la fecha",
                        e
                );
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);
        return fecha;
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
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Mostrando libros");
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
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Accediendo a la gestion del stock");
        String isbn = sc.pideTexto("Introduce el ISBN: ").toUpperCase();
        Libro libro = getLibro(isbn);
        if (libro != null) {
            int nuevo_stock = sc.pedirNumero("Introduce el nuevo stock del libro " + libro.getTitulo() + ": ");
            if (nuevo_stock > 0) {
                stock.put(libro, nuevo_stock);
                System.out.println("✅ Stock actualizado exitosamente!");
                MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Stock actualizado correctamente");
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
        MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Inicializando prestamo");
        String isbn = sc.pideTexto("Introduce el ISBN: ").toUpperCase();
        Libro libro = getLibro(isbn);
        if (libro != null) {
            stock.put(libro, stock.get(libro) - 1);
            registrarPrestamo(libro);
            System.out.println("✅ Libro prestado exitosamente!");
            MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Libro prestado correctamente");
        } else {
            System.out.println("❌ El libro no existe con el ISBN dado!");
        }
    }

    public static void crearArchivoPrestamo(Libro libro) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";
        if (comprobarDirectorio(ruta)) {
            LocalDateTime fecha = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyHHmm");
            String fecha_formateada = formatter.format(fecha);
            File archivo = new File(ruta + libro.getIsbn() + "-" + fecha_formateada + ".txt");

            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            try (FileWriter fw = new FileWriter(archivo)) {
                fw.write("----- PRESTAMO -----\n");
                fw.write("Fecha prestamo: " + formatter2.format(fecha) + "\n");
                fw.write("Libro:\n");
                fw.write("\tISBN: " + libro.getIsbn() + "\n");
                fw.write("\tTitulo: " + libro.getTitulo() + "\n");
                fw.write("\tAutor: " + libro.getAutor() + "\n");
                fw.write("-----------------------");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de prestamo!" + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }

    public static void registrarPrestamo(Libro libro) {
        String ruta = System.getProperty("user.home") + "/Desktop/DAM/simulacros/";
        if (comprobarDirectorio(ruta)) {
            File archivo = new File(ruta + "prestamos.txt");

            MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Inicilizando el registro del prestamo");
            try (FileWriter fw = new FileWriter(archivo, true)) {

                fw.write("----- PRESTAMO -----\n");
                fw.write("Fecha prestamo: " + LocalDate.now() + "\n");
                fw.write("Libro:\n");
                fw.write("\tISBN: " + libro.getIsbn() + "\n");
                fw.write("\tTitulo: " + libro.getTitulo() + "\n");
                fw.write("\tAutor: " + libro.getAutor() + "\n");
                fw.write("-----------------------");

                MyLogger.logInfo(GestionLibreria.class.getSimpleName(),"Prestamo registrado correctamente");
            } catch (IOException e) {
                MyLogger.logError(
                        GestionLibreria.class.getSimpleName(),
                        "Error en el registro del prestamo",
                        e
                );
                System.out.println("Error al registrar el prestamo. " + e.getMessage());
            }
        } else {
            System.out.println("Algo ha fallado.");
        }
    }

    private static boolean comprobarDirectorio(String ruta) {
        if (Utilidades.existDirectory(ruta)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(ruta);
        }
    }
}
