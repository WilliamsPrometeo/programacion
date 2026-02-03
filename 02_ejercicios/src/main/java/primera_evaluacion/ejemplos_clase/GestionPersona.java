package primera_evaluacion.ejemplos_clase;

import recursos.MyScanner;
import primera_evaluacion.ejemplos_clase.clases.Personas;
import recursos.exceptions.MyException;

public class GestionPersona {
    private static final MyScanner sc = new MyScanner();
    private static Personas persona = new Personas();

    public static void main(String[] args) throws MyException {
        persona = pedirDatosPersona();
        menuPersona();
    }

    public static Personas pedirDatosPersona() {
        Personas persona = new Personas();

        persona.setNombre(sc.pedirSoloTexto("Ingrese su nombre: "));
        persona.setApellido(sc.pedirSoloTexto("Ingrese su apellido: "));
        persona.setEdad(sc.pedirNumero("Ingrese su edad: "));

        return persona;
    }

    public static void menuPersona() throws MyException {
        boolean exit = false;
        while (!exit) {
            System.out.println("---------Cuenta bancaria----------");
            System.out.println("\t1. Mostrar saldo");
            System.out.println("\t2. Retirar dinero");
            System.out.println("\t3. Ingresar dinero");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero(" Opcion:  ");
            switch (opcion) {
                case 1:
                    mostrarSaldo();
                    break;
                case 2:
                    retirar();
                    break;
                case 3:
                    ingresar();
                    break;
                case 0:
                    System.out.println("\n*****Hasta Luego*****");
                    exit = true;
                    break;
                default:
                    System.out.println("*****Opcion no valida*****");
                    break;
            }
        }
    }

    public static void mostrarSaldo(){
        System.out.println("Cantidad disponible: " + persona.getDinero_en_banco());
    }

    public static void retirar() throws MyException {
        int dinero_en_banco = persona.getDinero_en_banco();
        try {
            mostrarSaldo();
            int cantidad = sc.pedirNumero("Ingrese la cantidad a retirar: ");
            if (cantidad > dinero_en_banco) {
                throw new MyException("❌ ERROR:: No tiene tanta cantidad de dinero en el banco!!");
            }
            persona.setDinero_en_banco(dinero_en_banco - cantidad);
            System.out.println("Transacción realizada. \n***************");
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void ingresar(){
        mostrarSaldo();
        int cantidad = sc.pedirNumero("Ingrese la cantidad a ingresar: ");
        int  dinero_en_banco = persona.getDinero_en_banco();

        persona.setDinero_en_banco(dinero_en_banco + cantidad);
        System.out.println("Transacción realizada.\n***************");
    }
}
