package practica_02;

import practica_02.clases.Taller;
import recursos.MyScanner;

/**
 * Clase principal de la aplicación de gestión del taller.
 * Contiene el metodo {@code main} y gestiona el menú principal
 * de interacción con el usuario.
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class MainTaller {

    /** Objeto para la entrada de datos por consola */
    private static final MyScanner sc = new MyScanner();

    /** Instancia del taller que gestiona la lógica de la aplicación */
    private static Taller taller = new Taller();

    public static void main(String[] args) {
        menu();
    }

    /**
     * Muestra el menú principal de la aplicación y gestiona
     * la selección de opciones del usuario.
     *
     * El menú se repite hasta que el usuario elige la opción de salir.
     */
    public static void menu() {
        int opcion;
        do {
            System.out.println("===GESTIÓN TALLER===");
            opcion = sc.pedirNumero(
                    "1. Registrar vehículo" +
                            "\n2. Registrar servicio" +
                            "\n3. Asignar servicio" +
                            "\n4. Mostrar vehículos" +
                            "\n5. Mostrar trabajos" +
                            "\n6. Salir" +
                            "\nOpción: "
            );

            switch (opcion) {
                case 1:
                    taller.registrarVehiculo();
                    break;
                case 2:
                    taller.registrarServicio();
                    break;
                case 3:
                    taller.asignarServicio();
                    break;
                case 4:
                    taller.mostrarVehiculos();
                    break;
                case 5:
                    taller.mostrarTrabajos();
                    break;
                case 6:
                    System.out.println("... Saliendo ...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 6);
    }
}
