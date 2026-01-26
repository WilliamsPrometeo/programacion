package ampliacion.simulacros.simularo04.clases;

import ampliacion.simulacros.simularo04.enums.Tipo;

import java.time.LocalDate;

public class Registro {
    private LocalDate fechaCreacion;
    private Tipo tipoRegistro;
    private String contenido;

    public Registro(LocalDate fechaCreacion, Tipo tipoRegistro, String contenido) {
        this.fechaCreacion = fechaCreacion;
        this.tipoRegistro = tipoRegistro;
        this.contenido = contenido;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Tipo getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(Tipo tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return String.format("Registro: %8s, fecha de creación %10s, contenido: %s", tipoRegistro, fechaCreacion, contenido);
    }
}
