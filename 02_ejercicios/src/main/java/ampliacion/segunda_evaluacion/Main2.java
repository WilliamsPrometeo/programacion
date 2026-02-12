package ampliacion.segunda_evaluacion;

import recursos.MyScanner;

public class Main2 {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        String validadores = "^[A-Z]{3}[0-9]{2}$";
        String texto = sc.pideTexto("Introduce algo: ").toUpperCase();
        if (texto.matches(validadores)) {
            System.out.println("Formato correcto");
        } else {
            System.out.println("Formato incorrecto");
        }
    }
}
