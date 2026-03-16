package ampliacion.simulacros.simulacro_extra_02;

import recursos.MyScanner;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static final GestionClientes gestion = new GestionClientes();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            opcion = sc.pedirNumero("=== GESTION CLIENTES ===" +
                    "\n1. Agrear Cliente" +
                    "\n2. Mostrar Clientes" +
                    "\n3. Guardar clientes en fichero" +
                    "\n4. Cargar clientes desde fichero" +
                    "\n5. Salir" +
                    "\nOpción: ");
            switch (opcion) {
                case 1:
                    gestion.agregarCliente();
                    break;
                case 2:
                    gestion.mostrarClientes();
                    break;
                case 3:
                    gestion.guardarClientes();
                    break;
                case 4:
                    gestion.cargarClientes();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (opcion != 5);
    }
}
