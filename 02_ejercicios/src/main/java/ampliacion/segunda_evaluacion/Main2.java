package ampliacion.segunda_evaluacion;

import ampliacion.segunda_evaluacion.enums.Genero;
import recursos.MyScanner;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main2 {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
//        String validadores = "^[A-Z]{3}[0-9]{2}$";
//        String texto = sc.pideTexto("Introduce algo: ").toUpperCase();
//        if (texto.matches(validadores)) {
//            System.out.println("Formato correcto");
//        } else {
//            System.out.println("Formato incorrecto");
//        }

        ArrayList<String> lista = new ArrayList<>();

        lista.add("Cosas1");
        lista.add("Cosas2");
        lista.add("Cosas3");
        lista.add("Cosas4");
        lista.add("Cosas5");
        lista.add("Cosas6");
        lista.add("Cosas7");
        lista.add("Cosas8");
        lista.add("Cosas9");


        Persona persona = new Persona("456879S", "nombre", "apellido", Genero.MASCULINO, LocalDate.of(2025,1,2), lista);

        System.out.println(persona.getLista().get(5));
        persona.getLista().remove(5);
        System.out.println(persona.getLista().get(5));

        for (String items: persona.getLista()) {
            System.out.print("Enseñando item: ");
            System.out.println(items);
        }
    }
}
