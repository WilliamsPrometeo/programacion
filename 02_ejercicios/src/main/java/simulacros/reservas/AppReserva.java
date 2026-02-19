package simulacros.reservas;

import recursos.MyScanner;
import simulacros.reservas.controller.ReservaController;

public class AppReserva {

    private static final MyScanner sc = new MyScanner();
    private static final ReservaController controller = new ReservaController();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        boolean correcto = false;
        int opcion;
        do {
            opcion = sc.pedirNumero("===== GESTION RESERVAS =====\n" +
                    "1. Registrar reserva\n" +
                    "2. Listar reservas\n" +
                    "3. Buscar reserva\n" +
                    "4. Cancelar reserva\n" +
                    "5. Guardar datos\n" +
                    "6. Cargar datos\n" +
                    "0. Salir\n" +
                    "Opcion: ");
            switch (opcion) {
                case 1:
                    controller.addReserva();
                    break;
                case 2:
                    controller.listarReservas();
                    break;
                case 3:
                    controller.getReserva();
                    break;
                case 4:
                    controller.eliminarReserva();
                    break;
                case 5:
                    controller.guardar();
                    break;
                case 6:
                    controller.cargar();
                    break;
                case 0:
                    System.out.println("Saliendo ...");
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
    }
}
