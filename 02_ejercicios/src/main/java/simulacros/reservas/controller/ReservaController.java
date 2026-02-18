package simulacros.reservas.controller;

import recursos.MyScanner;
import simulacros.reservas.exceptions.InvalidDateException;
import simulacros.reservas.exceptions.InvalidReservaException;
import simulacros.reservas.models.Reserva;
import simulacros.reservas.models.ReservaApartamento;
import simulacros.reservas.models.ReservaHotel;
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
            codigoReserva = sc.pideTexto("Introduce el código de reserva (AB1234): ").toUpperCase();
            try {
                service.reservaValida(codigoReserva);
            } catch (InvalidReservaException ex) {
                System.out.println(ex.getMessage());
                correcto = false;
            }
        } while (!validarCodigo(codigoReserva) || !correcto);

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
                    service.addReserva(new ReservaHotel(codigoReserva, fechaEntrada, fechaSalida, incluyeDesayuno()));
                    break;
                case 2:
                    service.addReserva(new ReservaApartamento(codigoReserva, fechaEntrada, fechaSalida, 11));
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

    private boolean validarCodigo(String codigoReserva) {
        String regex = "^[A-Z]{2}[0-9]{4}$";

        return codigoReserva.matches(regex);
    }
}
