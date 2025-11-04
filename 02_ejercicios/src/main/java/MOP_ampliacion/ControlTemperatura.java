package MOP_ampliacion;

import recursos.MyScanner;

public class ControlTemperatura {

    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        int temperatura = pideTemperatura();

        System.out.println(comprobarTemperatura(temperatura));

    }

    public static int pideTemperatura() {
        boolean salida;
        int temperatura;

        do {
            temperatura = sc.pedirNumero("Ingrese el temperatura: ");
            if (temperatura >= 150 || temperatura <= 0) {
                System.out.println("Rango de temperatura no valido.");
                salida = false;
            } else {
                salida = true;
            }
        } while (!salida);

        return temperatura;
    }

    public static String comprobarTemperatura(int temperatura) {
        String mensaje;

        if (temperatura > 100) {
            mensaje = "Eso es el sol!";
        } else if (temperatura > 50) {
            mensaje = "Hace demasiado calor, tienes que estar en el desierto.";
        } else if (temperatura > 25) {
            mensaje = "Que calor hace. ¿No estaras en la playa?";
        } else if (temperatura > 15) {
            mensaje = "Que bueno que hace, seguro que es primavera.";
        } else {
            mensaje = "Hace un poco de rasca. Ya llega el invierno";
        }

        return mensaje;
    }
}
