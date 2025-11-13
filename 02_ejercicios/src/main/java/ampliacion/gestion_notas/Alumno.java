package ampliacion.gestion_notas;

import java.util.ArrayList;

public class Alumno {
    private String nombre;
    private ArrayList<Double> notas;

    public Alumno() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        double media = 0;
        for (Double nota : notas) {
            media += nota;
        }
        media = media / notas.size();
        return media;
    }

    public String mostrarDatos() {
        String aprobado;
        if (calcularMedia() >= 5) {
            aprobado = "Aprobado";
        } else {
            aprobado = "Suspenso";
        }
        return "Nombre: " + getNombre() +
                "\nNotas: " + getNotas() +
                "\nMedia: " + calcularMedia()
                + ", " + aprobado;
    }
}
