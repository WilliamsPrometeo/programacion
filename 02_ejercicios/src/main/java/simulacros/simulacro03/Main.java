package simulacros.simulacro03;

import recursos.MyScanner;
import simulacros.simulacro03.clases.Libreria;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Libreria libreria = new Libreria();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean correcto = false;
        do {
            System.out.println("==== LIBRERIA PROMETEO ====");
            int opcion = sc.pedirNumero("1. Registrar usuario" +
                    "\n2. Registrar libro" +
                    "\n3. Prestar libro" +
                    "\n4. Mostrar libros disponibles" +
                    "\n5. Mostrar préstamos" +
                    "\n6. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    libreria.registrarUsuario();
                    break;
                case 2:
                    libreria.registrarLibro();
                    break;
                case 3:
                    System.out.println(libreria.prestarLibro());
                    break;
                case 4:
                    libreria.mostarLibros();
                    break;
                case 5:
                    libreria.mostarPrestamos();
                    break;
                case 6:
                    System.out.println("... Saliendo ...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!correcto);
    }
}
