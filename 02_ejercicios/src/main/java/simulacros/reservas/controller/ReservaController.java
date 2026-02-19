package simulacros.reservas.controller;

import recursos.MyScanner;
import recursos.Utilidades;
import simulacros.reservas.exceptions.InvalidDateException;
import simulacros.reservas.exceptions.InvalidReservaException;
import simulacros.reservas.models.Reserva;
import simulacros.reservas.models.ReservaApartamento;
import simulacros.reservas.models.ReservaHotel;
import simulacros.reservas.models.enums.TipoHabitacion;
import simulacros.reservas.service.ReservaService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ReservaController {

    private static final MyScanner sc = new MyScanner();

    private final ReservaService service = new ReservaService();

    public void addReserva() {
        boolean correcto;
        String codigoReserva = "";
        do {
            correcto = true;
            codigoReserva = getCodigo();
            try {
                service.reservaValida(codigoReserva);
            } catch (InvalidReservaException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        do {
            correcto = true;
            try {
                String entrada = sc.pideTexto("Introduce la fecha de entrada (yyyy-MM-dd): ");
                fechaEntrada = LocalDate.parse(entrada);
                String salida = sc.pideTexto("Introduce la fecha de salida (yyyy-MM-dd): ");
                fechaSalida = LocalDate.parse(salida);
                service.fechaValida(fechaEntrada, fechaSalida);
            } catch (DateTimeParseException | InvalidDateException ex) {
                System.out.println("Error: " + ex.getMessage());
                correcto = false;
            }
        } while (!correcto);

        do {
            correcto = true;
            int opcion = sc.pedirNumero("¿Qué resserva quieres realizar?: " +
                    "\n1. Reserva Hotel" +
                    "\n2. Reserva Apartamento" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    service.addReserva(new ReservaHotel(codigoReserva, fechaEntrada, fechaSalida, incluyeDesayuno()),
                            Utilidades.pedirEnum(TipoHabitacion.class, "Introduce el tipo de habitacion: "));
                    break;
                case 2:
                    service.addReserva(new ReservaApartamento(codigoReserva, fechaEntrada, fechaSalida, 11),
                            Utilidades.pedirEnum(TipoHabitacion.class, "Introduce el tipo de habitacion: "));
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

    }

    public void listarReservas() {
        Utilidades.imprimirMap(service.getReservas());
    }

    public void getReserva() {
        String codigo = getCodigo();

        Reserva reserva = service.getReserva(codigo);
        if (reserva != null) {
            System.out.println(reserva);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }

    public void eliminarReserva() {
        String codigo = getCodigo();
        if (service.eliminarReserva(codigo)) {
            System.out.println("Reserva cancelada correctamente");
        } else {
            System.out.println("Reserva no encontrada");
        }
    }

    public void guardar() {
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea guardar? (S/N: ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Guardando datos ...");
                    service.guardar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    public void cargar() {
        boolean correcto;
        char opcion;
        do {
            correcto = true;
            opcion = sc.pedirLetra("¿Desea cargar? (S/N: ");
            switch (opcion) {
                case 'S':
                case 's':
                    System.out.println("Cargando datos ...");
                    service.cargar();
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private boolean incluyeDesayuno() {
        boolean correcto;
        boolean salida = false;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Quieres incluir el desayuno? (S/N): ");
            switch (opcion) {
                case 'S':
                case 's':
                    salida = true;
                    break;
                case 'N':
                case 'n':
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        return salida;
    }

    private String getCodigo() {
        String regex = "^[A-Z]{2}[0-9]{4}$";
        String codigo;
        do {
            codigo = sc.pideTexto("Introduce el código de reserva (2 letras y 4 números): ").toUpperCase();
        } while (!codigo.matches(regex));
        return codigo;
    }
}
