package segunda_evaluacion.mvc;

import recursos.MyLogger;
import recursos.MyScanner;
import segunda_evaluacion.mvc.models.enums.Genero;
import segunda_evaluacion.mvc.controller.LibroController;
import segunda_evaluacion.mvc.dao.LibroJsonDAO;
import segunda_evaluacion.mvc.models.Libro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppLibro {

    private static final MyScanner sc = new MyScanner();
    private static final LibroController controller = new LibroController();
    private static final LibroJsonDAO jsonDAO = new LibroJsonDAO();

    public static void main(String[] args) {
        MyLogger.logInfo(AppLibro.class.getSimpleName(),"Iniciando programa");
        menu();
        MyLogger.logInfo(AppLibro.class.getSimpleName(),"Terminando programa");
//        List<Libro> libros = jsonDAO.leerLibros();
//        libros.add(new Libro("OPK", "JSON", "Yo", Genero.TERROR, LocalDate.now()));
//        for (Libro libro : libros) {
//            System.out.println(libro);
//        }
//        jsonDAO.guardarLibros(libros);
    }

    public static void menu() {
        MyLogger.logInfo(AppLibro.class.getSimpleName(),"Inicializando el menú");
        boolean exit;
        do {
            exit = false;
            int opcion = sc.pedirNumero(
                    "===== GESTION LIBRERIA =====" +
                    "\n1. Agregar libro" +
                    "\n2. Mostrar libros" +
                    "\n3. Gestionar stock libros" +
                    "\n4. Prestar libro" +
                    "\n5. Salir" +
                    "\nInserte la opcion que desee: ");
            switch (opcion) {
                case 1:
                    controller.agregarLibro();
                    break;
                case 2:
                    controller.mostrarLibros();
                    break;
                case 3:
                    controller.gestionarStock();
                    break;
                case 4:
                    controller.prestarLibro();
                    break;
                case 5:
                    controller.guardar();
                    System.out.println("Saliendo ....");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida!");
                    break;
            }
        } while (!exit);
    }
}
