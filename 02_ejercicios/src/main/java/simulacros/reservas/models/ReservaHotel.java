package simulacros.reservas.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReservaHotel extends Reserva {
    private boolean incluyeDesayuno;

    public ReservaHotel(String codigoReserva, LocalDate fechaEntrada, LocalDate fechaSalida, boolean desayuno) {
        super(codigoReserva, fechaEntrada, fechaSalida);
        this.incluyeDesayuno = desayuno;
    }

    public boolean isIncluyeDesayuno() {
        return incluyeDesayuno;
    }

    public void setIncluyeDesayuno(boolean incluyeDesayuno) {
        this.incluyeDesayuno = incluyeDesayuno;
    }

    @Override
    public String getTipoReserva() {
        return "Reserva Hotel";
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String entrada = super.getFechaEntrada().format(dtf);
        String salida = super.getFechaSalida().format(dtf);
        String desayuno = this.incluyeDesayuno ? "Desayuno incluido" : "Desyuno no incluido";
        return String.format("Reserva hotel: %s, %s, %s, %s", super.getCodigoReserva(), entrada, salida, desayuno);
    }

}
