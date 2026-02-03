package primera_evaluacion.ejemplos_clase;

import recursos.MyScanner;

public class Ejemplos {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        String s = sc.pedirSoloTexto("Texto: ");

        s = s.replace('a', 'e');
        s = s.replace('i', 'e');
        s = s.replace('o', 'e');
        s = s.replace('u', 'e');

        System.out.println(s);

        char primero = s.charAt(0);
        char ultima = s.charAt(s.length() - 1);


        System.out.println("Primera letra: " + primero);
        System.out.println("Ultima letra: " + ultima);

        String cosa = s.toUpperCase().contains("PEPE") ? "Hola" : "Adios";

        System.out.println(cosa);
    }
}
