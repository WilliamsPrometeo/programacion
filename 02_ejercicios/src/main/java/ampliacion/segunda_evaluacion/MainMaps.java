package ampliacion.segunda_evaluacion;

import java.util.HashMap;
import java.util.Map;

public class MainMaps {
    public static void main(String[] args) {
        Map<String, Integer> mapa = new HashMap<>();

        mapa.put("clave1", 5);
        mapa.put("clave1", 8);

        int num = mapa.get("clave1");

        Map<String, String> mapa2 = new HashMap<>();

        mapa2.put("clave3", "valores");
        mapa2.put("clave4", "valores2");

        System.out.println(mapa2.get("clave4"));

        System.out.println(num);
    }
}
