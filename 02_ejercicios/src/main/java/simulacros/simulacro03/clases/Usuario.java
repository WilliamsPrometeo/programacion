package simulacros.simulacro03.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Usuario extends Persona {
    private LocalDateTime fecha_alta;

    public Usuario() {
        fecha_alta = LocalDateTime.now();
    }

    public Usuario(String nombre, String dni) {
        super(nombre, dni);
        fecha_alta = LocalDateTime.now();
    }

    public LocalDateTime getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDateTime fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fecha_formateada = getFecha_alta().format(formatter);
        return String.format("Usuario: %s, DNI: %s, Fecha de alta: %s.", super.getNombre(), super.getDni(), fecha_formateada);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return super.getDni() != null ? super.getDni().equals(usuario.getDni()) : usuario.getDni() == null;
    }

    @Override
    public int hashCode() {
        return super.getDni() != null ? super.getDni().hashCode() : 0;
    }
}
