package ampliacion;

import recursos.MyScanner;

public class ControlAcceso_profesor {
    // Instacia estática del MyScanner para su uso en el proyecto
    private static final MyScanner sc = new MyScanner();

    public static void main (String[] args) throws EdadException {
//        MyScanner sc = new MyScanner();
        int intentos = 1;
        boolean salida;
        int edad;
        do {
            try{
                edad = sc.pedirNumero("Ingrese su edad.");
                if (edad<0 || edad >120) {
                    throw new EdadException("Error: Edad no válida. Intento " + intentos + " de 3.");
                }
                if (edad<18) {
                    System.out.println("Acceso denegado: menor de edad");
                } else if (edad <= 65) {
                    System.out.println("Acceso permitido");
                } else {
                    System.out.println("Acceso con beneficios para jubilados");
                }
                salida = true;
            } catch (EdadException exception) {
                System.out.println(exception.getMessage());
                intentos++;
                salida = false;
            }
        } while (!salida && intentos<=3);

        sc.cerrar();
    }
}
