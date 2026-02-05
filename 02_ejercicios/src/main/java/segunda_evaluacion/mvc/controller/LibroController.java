package segunda_evaluacion.mvc.controller;

import recursos.MyLogger;
import recursos.MyScanner;
import recursos.Utilidades;
import segunda_evaluacion.libreria.exceptions.InvalidDateException;
import segunda_evaluacion.mvc.exceptions.InvalidException;
import segunda_evaluacion.mvc.models.Libro;
import segunda_evaluacion.mvc.models.enums.Genero;
import segunda_evaluacion.mvc.service.LibroService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LibroController {

    private static final MyScanner sc = new MyScanner();
    private final LibroService service = new LibroService();

    public void agregarLibro() {
        try {
            String isbn = getIsbn();
            if (service.existeLibro(isbn)) {
                throw new InvalidException("Ya hay un libro con ese ISBN");
            }
            String titulo = sc.pideTexto("Introduce el titulo: ");
            String autor = sc.pideTexto("Introduce el autor: ");
            Genero genero = Utilidades.pedirEnum(Genero.class,"Introduce el genero: ");
            LocalDate fecha = getFecha();

            service.agregarLibro(isbn, titulo, autor, genero, fecha, 1);
            MyLogger.logInfo(this.getClass().getSimpleName(), "Libro agregado.");
        } catch (InvalidException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al agregar un libro",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    public void prestarLibro() {
        String isbn = getIsbn();
        try {
            service.prestarLibro(isbn);
        } catch (InvalidException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al prestar el libro.",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    public void mostrarLibros() {
        Utilidades.imprimirMap(service.obtenerInventario());
    }

    public void gestionarStock() {
        String isbn = getIsbn();
        int stock = sc.pedirNumero("Introduce el nuevo stock: ");
        try {
            service.actualizarStock(isbn, stock);
        } catch (InvalidException e) {
            MyLogger.logError(
                    this.getClass().getSimpleName(),
                    "Error al actualizar stock.",
                    e
            );
            System.out.println(e.getMessage());
        }
    }

    public void guardar() {
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea guardar? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos ....");
                    MyLogger.logInfo(this.getClass().getSimpleName(), "Guardado de datos");
                    service.guardar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private static LocalDate getFecha() {
        boolean correcto;
        LocalDate fecha = null;

        do {
            correcto = true;
            String fechaString = sc.pideTexto("Introduce la fecha(YYYY-MM-DD): ");
            try {
                fecha = LocalDate.parse(fechaString);
                if (fecha.isAfter(LocalDate.now()) || fecha.getYear() < 1200) {
                    throw new InvalidDateException(fecha, 1200, LocalDate.now().getYear());
                }
            } catch (DateTimeParseException | InvalidDateException e) {
                MyLogger.logError(
                        LibroController.class.getSimpleName(),
                        "Error en la fecha",
                        e
                );
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        return fecha;
    }

    private static String getIsbn() {
        String isbn;
        String validadores = "^[A-Z]{3}[0-9]{2}$";
        do {
            isbn = sc.pideTexto("Introduce el ISBN (3 letras y 2 números): ").toUpperCase();
        } while (!isbn.matches(validadores));
        return isbn;
    }
}
