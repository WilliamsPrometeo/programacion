package ejemplos_clase.herencia.banco;

import ejemplos_clase.herencia.banco.clases.Banco;
import ejemplos_clase.herencia.banco.clases.Cuenta;
import ejemplos_clase.herencia.banco.clases.EmpleadoBanco;
import ejemplos_clase.herencia.banco.enums.Divisa;
import ejemplos_clase.herencia.concesionario.clases.Cliente;
import recursos.MyScanner;

import java.util.ArrayList;

public class GestionBanco {
    private static final MyScanner sc = new MyScanner();
    private static Banco banco;
    private static ArrayList<EmpleadoBanco> empleados = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int num_cuenta = 111;

    public static void main(String[] args) {

    }

    private static void menuEmpleado(EmpleadoBanco empleado, ArrayList<Cliente> clientes) {
        boolean correcto;
        do {
            int opcion = sc.pedirNumero("1. Agregar cuenta" +
                    "\n2. Eliminar cuenta" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:

                    correcto = true;
                    break;
                case 2:

                    correcto = true;
                    break;
                default:
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private static void addCuenta(Cliente cliente) {
        boolean correcto;
        Divisa divisa = null;
        do {
            System.out.println("Introduce la divisa de tu cuenta: ");
            int opcion = sc.pedirNumero("1. EURO" +
                    "\n2. DOLAR" +
                    "\n3. RUPIAS" +
                    "\n4. YENES" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    divisa = Divisa.EURO;
                    correcto = true;
                    break;
                case 2:
                    divisa = Divisa.DOLAR;
                    correcto = true;
                    break;
                case 3:
                    divisa = Divisa.RUPIAS;
                    correcto = true;
                    break;
                case 4:
                    divisa = Divisa.YENES;
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    correcto = false;
                    break;
            }
        } while (!correcto);

        String numero_cuenta = "ES" + num_cuenta;

        cliente.setCuenta(new Cuenta(numero_cuenta, divisa));
        num_cuenta++;

    }

    private static void gestionarCuenta(Cuenta cuenta) {
        boolean correcto;
        do {
            System.out.println("=========GESTION BANCO==========");
            int opcion = sc.pedirNumero("1. Agregar dinero" +
                    "\n2. Retirar dinero" +
                    "\n3. Mostrar saldo" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    addDinero(cuenta);
                    correcto = true;
                    break;
                case 2:
                    retirarDinero(cuenta);
                    correcto = true;
                    break;
                case 3:
                    System.out.printf("Cantidad disponible: %.2f", cuenta.getCantidad_dinero());
                    correcto = true;
                    break;
                default:
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private static void addDinero(Cuenta cuenta) {
        boolean correcto;
        double saldo = cuenta.getCantidad_dinero();
        double cantidad;
        do {
            cantidad = sc.pedirDecimal("Inserte la cantidad de dinero a ingresar: ");
            if (cantidad <= 0) {
                System.out.println("Cantidad invalida");
                correcto = false;
            } else {
                cuenta.setCantidad_dinero(cantidad + saldo);
                correcto = true;
            }
        } while (!correcto);
    }

    private static void retirarDinero(Cuenta cuenta) {
        boolean correcto;
        double saldo = cuenta.getCantidad_dinero();
        double cantidad;
        do {
            System.out.printf("Dinero disponible: %.2f", saldo);
            cantidad = sc.pedirDecimal("Inserte la cantidad de dinero a retirar: ");
            if (cantidad > saldo || cantidad <= 0) {
                System.out.println("No pude retirar esa cantidad.");
                correcto = false;
            } else {
                cuenta.setCantidad_dinero(saldo - cantidad);
                correcto = true;
            }
        } while (!correcto);
    }
}
