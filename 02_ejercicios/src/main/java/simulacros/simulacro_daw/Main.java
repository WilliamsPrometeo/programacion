package simulacros.simulacro_daw;

import recursos.MyScanner;
import simulacros.simulacro_daw.controller.BibliotecaController;

public class Main {
    private static final MyScanner sc = new MyScanner();
    private static final BibliotecaController controller = new BibliotecaController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("==== Biblioteca ====" +
                    "\n1. Registrar libro" +
                    "\n2. Mostrar libros" +
                    "\n3. Guardar en fichero" +
                    "\n4. Cargar desde fichero" +
                    "\n5. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    controller.addLibro();
                    break;
                case 2:
                    controller.mostrarLibros();
                    break;
                case 3:
                    controller.guardar();
                    break;
                case 4:
                    controller.cargar();
                    break;
                case 5:
                    System.out.println("Saliendo ...");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 5);
    }
}
