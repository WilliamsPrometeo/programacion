package ejemplos_clase.herencia;

import ejemplos_clase.herencia.clases.*;
import ejemplos_clase.herencia.enums.Marca;
import ejemplos_clase.herencia.exception.HerenciaException;
import recursos.MyScanner;

import java.util.ArrayList;

public class GestionConcesionario {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        rellenarVehiculos();

    }

    private static void rellenarVehiculos() {
        Coche kia = new Coche(Marca.KIA, 14999.99, 5, true);
        Coche bmw = new Coche(Marca.BMW, 80000, 3, false);
        Coche mercedes = new Coche(Marca.MERCEDES, 40000, 5, true);
        Moto ducati = new Moto(Marca.DUCATI, 9999.99, 250, false);
        Moto yamaha = new Moto(Marca.YAMAHA, 15000, 250, false);
        Moto kawasaki = new Moto(Marca.KAWASAKI, 6000.59, 1000, true);
    }

    public static void menuPrincipal() {
        boolean salir = false;
        while (!salir) {
            System.out.println("******* PROMETEO CONCESSIONARIO *******");
            int opcion = sc.pedirNumero("1. Registro" +
                    "\n2. Continuar" +
                    "\n3. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    registro();
                    break;
                case 2:
                    break;
                case 3:
                    salir = true;
                    System.out.println("******* SALIENDO *******");
                    System.out.println("******* ADIOS 👋🏼 *******");
                    break;
                default:
                    break;
            }
        }
    }

    public static void registro() {
        if (personas.isEmpty()) {
            registrar();
        } else {

            System.out.println("******* INICIO *******");
            int opcion = sc.pedirNumero("1. Registro" +
                    "\n2. Inicio Sesion" +
                    "\n3. Atrás" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    registrar();
                    break;
                case 2:
                    iniciar();
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
    }

    private static void iniciar() {
        boolean correcto;
        do {
            System.out.println("¿Como quiere iniciar Sesión?");
            int opcion = sc.pedirNumero("1. Cliente" +
                    "\n2. Empleado" +
                    "\n3. Atras" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:

                    correcto = true;
                break;
                case 2:

                    correcto = true;
                break;
                case 3:
                    correcto = true;
                break;
                default:
                    correcto = false;
                break;
            }

        } while (!correcto);
    }

    private static void inicioCliente() throws HerenciaException {
        mostrarClientes();
        int opcion = sc.pedirNumero("Ingrese el numero del cliente: ");
        for (Persona persona : personas) {
            if (persona instanceof Cliente) {
                if (((Cliente) persona).getNum_cliente() == opcion) {
                    System.out.printf("Iniciando Sesion.... con cliente: %d" ,  opcion);
                    return;
                }
            }
        }
        throw new HerenciaException("No existe un cliente con ese número.");
    }

    private static void mostrarClientes() {
        System.out.println("******* CLIENTES *******");
        for (Persona clientes : personas) {
            if (clientes instanceof Cliente) {
                System.out.println(clientes);
            }
        }
    }

    private static void mostrarEmpleados() {
        System.out.println("******* EMPLEADOS *******");
        for (Persona empleados : personas) {
            if (empleados instanceof Empleado) {
                System.out.println(empleados);
            }
        }
    }

    private static void registrar() {
        boolean correcto;
        do {
            System.out.println("******* REGISTRO *******");
            int opcion = sc.pedirNumero("1. Empleado" +
                    "\n2. Cliente" +
                    "\n3. Atrás" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    personas.add(crearEmpleado());
                    correcto = true;
                    break;
                case 2:
                    personas.add(crearCliente());
                    correcto = true;
                    break;
                case 3:
                    correcto = true;
                    break;
                default:
                    correcto = false;
                    break;
            }

        } while (!correcto);
    }

    public static Empleado crearEmpleado() {
        String nombre = sc.pedirSoloTexto("Ingrese el nombre del empleado: ");
        String apellido = sc.pedirSoloTexto("Ingrese el apellido del empleado: ");
        int edad = sc.pedirNumero("Ingrese edad del empleado: ");
        int num_empleado = sc.pedirNumero("Ingrese numero de empleado: ");

        return new Empleado(nombre, apellido, edad, num_empleado);
    }

    public static Cliente crearCliente() {
        String nombre = sc.pedirSoloTexto("Ingrese el nombre del cliente: ");
        String apellido = sc.pedirSoloTexto("Ingrese el apellido del cliente: ");
        int edad = sc.pedirNumero("Ingrese edad del cliente: ");
        int num_cliente = sc.pedirNumero("Ingrese numero de cliente: ");

        return new Cliente(nombre, apellido, edad, num_cliente);
    }
}
