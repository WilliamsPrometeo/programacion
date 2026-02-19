package simulacros.reservas.repository;

import simulacros.reservas.exceptions.InvalidDateException;
import simulacros.reservas.exceptions.InvalidReservaException;
import simulacros.reservas.models.Reserva;
import simulacros.reservas.models.enums.TipoHabitacion;

import java.time.LocalDate;
import java.util.Map;

public interface ReservaRepository {

    Map<Reserva, TipoHabitacion> getReservas();
    void addReserva(Reserva reserva, TipoHabitacion tipoHabitacion);

    Reserva getReserva(String codigo);
    boolean eliminarReserva(String codigo);

    void guardar();
    void cargar();

    boolean reservaValida(String codigoReserva) throws InvalidReservaException;
    boolean fechaValida(LocalDate entrada, LocalDate salida) throws InvalidDateException;

}
