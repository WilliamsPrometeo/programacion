package segunda_evaluacion.libreria;

import recursos.MyScanner;
import segunda_evaluacion.libreria.clases.Biblioteca;
import segunda_evaluacion.libreria.clases.Direccion;
import segunda_evaluacion.libreria.clases.Libro;
import segunda_evaluacion.libreria.clases.enums.Provincia;

import java.util.ArrayList;

public class GestionLibreria {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static Biblioteca biblioteca;

    public static void main(String[] args) {
        biblioteca = generarBiblioteca();
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
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
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

    public static Biblioteca generarBiblioteca() {
        Direccion direccion = new Direccion("Goya", 5, 3, 'H', 28022, Provincia.MADRID);
        return new Biblioteca("PaquitaSalas", libros, direccion);
    }
}
