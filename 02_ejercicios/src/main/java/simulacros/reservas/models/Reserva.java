package simulacros.reservas.models;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Reserva implements Serializable {

    private static final long serialVersionUID = 1L;

    private String codigoReserva;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    public Reserva(String codigoReserva, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.codigoReserva = codigoReserva;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public abstract String getTipoReserva();

    @Override
    public int hashCode() {
        return codigoReserva != null ? codigoReserva.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Reserva reserva = (Reserva) obj;
        return this.codigoReserva != null ? this.codigoReserva.equals(reserva.codigoReserva) : reserva.codigoReserva == null;
    }
}
