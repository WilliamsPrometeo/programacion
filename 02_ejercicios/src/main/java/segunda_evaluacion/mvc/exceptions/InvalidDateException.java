package segunda_evaluacion.mvc.exceptions;

import java.time.LocalDate;

public class InvalidDateException extends Exception {

    private final LocalDate fechaIntroducida;
    private final int yearMin;
    private final int yearMax;

    public InvalidDateException(LocalDate fechaIntroducida, int yearMin, int yearMax) {
        super();
        this.fechaIntroducida = fechaIntroducida;
        this.yearMin = yearMin;
        this.yearMax = yearMax;
    }

    @Override
    public String getMessage() {
        if (fechaIntroducida.isAfter(LocalDate.now())) {
            return "La fecha no puede ser futura: " + fechaIntroducida;
        }
        return "El año debe estar entre "+ yearMin+" y "+ yearMax;
    }
}
