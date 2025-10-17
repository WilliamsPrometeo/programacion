import java.util.Scanner;

public class ApuntesClase {
    static void main(String[] args) throws MiExcepcion {
        prueba();
    }

    public static void prueba() throws MiExcepcion{
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su edad");
        int edad = sc.nextInt();
        if (edad < 18) {
            throw new MiExcepcion("Eres menor de edad");
        }

    }

    public static class MiExcepcion extends Exception {
        public MiExcepcion(String mensaje) {
            super( mensaje );
        }
    }
}

