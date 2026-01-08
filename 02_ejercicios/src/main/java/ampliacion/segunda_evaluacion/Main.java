package ampliacion.segunda_evaluacion;

import recursos.MyScanner;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        Persona persona = new Persona("123", "Paco", "Perez");
        Persona persona2 = new Persona("123", "Maria", "Perez");

        System.out.println(persona.equals(persona2));
        persona2.setDni("345");
        System.out.println(persona.equals(persona2));

//        Map<Persona, String> mapa = new HashMap<Persona, String>();
//
//        mapa.put(persona, "Este es Paco, tiene un saludo");
//        mapa.put(persona2, "Este es Maria, tiene un saludo");
    }
}
