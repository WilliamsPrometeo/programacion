package ejemplos_clase;

import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        ArrayList<String> asignaturas = new ArrayList<>();
        asignaturas.add("Programacion");
        asignaturas.add("Bases de datos");
        asignaturas.add("Ampliacion Programacion");
        asignaturas.add("Lenguaje de marcas");
        asignaturas.add("IPE");
        asignaturas.add("Entornos de desarrollo");

        Map<String, Integer> notas = new HashMap<>();

        for (String asignatura : asignaturas) {
            notas.put(asignatura, sc.pedirNumero("Introduce la nota de " + asignatura + ": "));
        }

        for (String key : notas.keySet()) {
            System.out.println(key + ": " + notas.get(key));
        }
    }

}
