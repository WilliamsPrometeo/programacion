package ampliacion.segunda_evaluacion.clase;

import ampliacion.segunda_evaluacion.clase.clases.Vehiculo;
import recursos.MyScanner;
import recursos.Utilidades;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final MyScanner sc = new MyScanner();
    private static Map<Vehiculo, String> vehiculoMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        String matricula;
        Vehiculo v;
        do {
            matricula = getMatricula();
            v = new Vehiculo(matricula);
        } while (vehiculoMap.containsKey(v));

        String modelo = sc.pideTexto("Introduce la marca: ");
        v.setModelo(modelo);
        String color = sc.pideTexto("Introduce el color: ");
        v.setColor(color);

        vehiculoMap.put(v, sc.pedirSoloTexto("Introduce el valor del mapa: "));

        Utilidades.imprimirMap(vehiculoMap);
    }

    private static String getMatricula() {
        String regex = "^[0-9]{4}[A-Z]{3}$";
        String matricula = "";
        do {
            matricula = sc.pideTexto("Introduce la matricula (4 numeros y 3 letras): ").toUpperCase();
        } while (!matricula.matches(regex));
        return matricula;
    }
}
