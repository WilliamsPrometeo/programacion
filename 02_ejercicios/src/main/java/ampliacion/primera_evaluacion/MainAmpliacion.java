package ampliacion.primera_evaluacion;

import recursos.MyScanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainAmpliacion {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
//        int numero = sc.pedirNumero("Numero: ");
//
//        String dato = (numero % 2 == 0) ? "Par" : "Impar";
//
//        System.out.println(dato);
//
//        boolean correcto;
//
//        do {
//            int opcion = sc.pedirNumero("1. Sumar" +
//                    "\n2. Restar");
//
//            switch (opcion) {
//                case 1:
//                    System.out.println(numero + numero);
//                    correcto = true;
//                    break;
//                case 2:
//                    System.out.println(numero - numero);
//                    correcto = true;
//                    break;
//                default:
//                    correcto = false;
//                    System.out.println("Opcion no valida.");
//                    break;
//            }
//        } while (!correcto);

//        String texto = sc.pedirSoloTexto("Texto: ");
//        System.out.println("Primera letra: " + texto.charAt(0));
//        System.out.println("Ultima letra: " + texto.charAt(texto.length()-1));
//
//        if (texto.toLowerCase().contains("cosa")) {
//            System.out.println("contains true: "+texto);
//        }
//
//        if (texto.equalsIgnoreCase("cosa")) {
//            System.out.println("Son cosas iguales");
//        } else {
//            System.out.println("No son cosas iguales");
//        }
//
//        int numero = sc.pedirNumero("Numero: ");
//
//        String num = String.valueOf(numero);
//
//        int otro = Integer.parseInt(num);
//
//        System.out.println(otro);
//
//        if (num.matches("[0-9]+")){
//            System.out.println(num);
//        }

//        int num = sc.pedirNumero("Introduce un número: ");
//        String par = num%2 == 0 ? "Par" : "Impar";
//
//        boolean ternario = num%2 == 0 ? num%4 == 0 : num%3==0;
//
//        System.out.println(par);

        ArrayList<String> asignaturas = new ArrayList<>();
        asignaturas.add("Programacion");
        asignaturas.add("Lenguaje de marcas");
        asignaturas.add("Ampliacion");
        asignaturas.add("IPE");

        Map<String, Integer> notas = new HashMap<>();

        int nota1 = notas.get("Programacion") == null ? 0 : notas.get("Programacion") ;
        System.out.println(nota1);

        for (String asignatura : asignaturas) {
            notas.put(asignatura, sc.pedirNumero("Ingrese la nota de " + asignatura + ": "));
        }

        int nota2 = notas.get("Programacion") == null ? 0 : notas.get("Programacion") ;
        System.out.println(nota2);

        System.out.println("=== NOTAS ===");
        for (String key : notas.keySet()) {
            System.out.println(key + ": " + notas.get(key));
        }

    }
}
