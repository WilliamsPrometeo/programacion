package simulacros.reservas.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaApartamento extends Reserva {
    private int numApartamento;

    public ReservaApartamento(String codigoReserva, LocalDate fechaEntrada, LocalDate fechaSalida, int numApartamento) {
        super(codigoReserva, fechaEntrada, fechaSalida);
        this.numApartamento = numApartamento;
    }

    public int getNumApartamento() {
        return numApartamento;
    }

    public void setNumApartamento(int numApartamento) {
        this.numApartamento = numApartamento;
    }

    @Override
    public String getTipoReserva() {
        return "Reserva apartamento";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);
        String salida = super.getFechaSalida().format(dtf);
        return String.format("Reserva Apartamento: %s, %s, %s, %d", super.getCodigoReserva(), entrada, salida, this.numApartamento);
    }
}
