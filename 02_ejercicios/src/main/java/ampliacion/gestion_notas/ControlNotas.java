package ampliacion.gestion_notas;

import recursos.MyScanner;

import java.util.ArrayList;

/*
    Profesor - Williams
    Curso: DAW 1 - Ampliación de Programación
    Fecha: 13/11/2025
 */

public class ControlNotas {

    //Instancia de un atributo estático para su uso en el controlador
    private static final MyScanner scanner = new MyScanner();

    public static void main(String[] args) {
        boolean correcto;
        Alumno alumno = new Alumno();
        String nombre = scanner.pedirSoloTexto("Inserte el nombre del alumno: ");
        alumno.setNombre(nombre);
        double notaProgramacion = 0;
        double notaBaseDatos = 0;
        double notaEntornos = 0;
        do {
            try {
                notaProgramacion = scanner.pedirNumero("Introduce la nota programacion: ");
                if (notaProgramacion < 0 || notaProgramacion > 10) {
                    throw new NotasException("Nota incorrecta.");
                }
                notaBaseDatos = scanner.pedirNumero("Introduce la nota base de datos: ");
                if (notaBaseDatos < 0 || notaBaseDatos > 10) {
                    throw new NotasException("Nota incorrecta.");
                }
                notaEntornos = scanner.pedirNumero("Introduce la nota entornos de programacion: ");
                if (notaEntornos < 0 || notaEntornos > 10) {
                    throw new NotasException("Nota incorrecta.");
                }
                correcto = true;
            } catch (NotasException e) {
                System.out.println("Error: " + e.getMessage());
                correcto = false;
            }
        } while (!correcto);

        ArrayList<Double> notas = new ArrayList<>();
        notas.add(notaProgramacion);
        notas.add(notaBaseDatos);
        notas.add(notaEntornos);
        alumno.setNotas(notas);

        System.out.println(alumno.mostrarDatos());
    }
}
