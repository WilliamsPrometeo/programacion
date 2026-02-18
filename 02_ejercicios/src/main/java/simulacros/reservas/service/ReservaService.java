package simulacros.reservas.service;

import simulacros.reservas.exceptions.InvalidDateException;
import simulacros.reservas.exceptions.InvalidReservaException;
import simulacros.reservas.models.Reserva;
import simulacros.reservas.models.enums.TipoHabitacion;
import simulacros.reservas.repository.ReservaRepository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReservaService implements ReservaRepository {
    private static Map<Reserva, TipoHabitacion> reservas = new LinkedHashMap<>();

    @Override
    public Map<Reserva, TipoHabitacion> getReservas() {
        return Map.copyOf(reservas);
    }

    @Override
    public void addReserva(Reserva reserva) {

    }

    @Override
    public boolean reservaValida(String codigoReserva) throws InvalidReservaException {
        for (Reserva reserva : reservas.keySet()) {
            if (reserva.getCodigoReserva().equals(codigoReserva)) {
                throw new InvalidReservaException("Codigo de reserva no valido");
            }
        }
        return true;
    }

    @Override
    public boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException {
        if (entrada.isAfter(salida)) {
            throw new InvalidDateException("La fecha de salida no puede ser anterior a la de entrada");
        }
        if (entrada.isBefore(LocalDate.now())) {
            throw new InvalidDateException("La fecha de entrada no puede ser anterior a la de hoy");
        }
        if (entrada.getYear() > LocalDate.now().getYear() + 1) {
            throw new InvalidDateException("La fecha de entrada no puede ser superior al año " + LocalDate.now().getYear() + 1);
        }
        return true;
    }
}
