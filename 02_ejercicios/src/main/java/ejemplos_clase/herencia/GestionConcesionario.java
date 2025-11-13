package ejemplos_clase.herencia;

import ejemplos_clase.herencia.clases.*;
import ejemplos_clase.herencia.enums.Marca;
import ejemplos_clase.herencia.exception.HerenciaException;
import recursos.MyScanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;

public class GestionConcesionario {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Factura> facturas = new ArrayList<>();

    public static void main(String[] args) {
        rellenarVehiculos();

    }

    private static void rellenarVehiculos() {
        Vehiculo kia = new Coche(Marca.KIA, 14999.99, 5, true);
        Vehiculo bmw = new Coche(Marca.BMW, 80000, 3, false);
        Vehiculo mercedes = new Coche(Marca.MERCEDES, 40000, 5, true);
        Vehiculo ducati = new Moto(Marca.DUCATI, 9999.99, 250, false);
        Vehiculo yamaha = new Moto(Marca.YAMAHA, 15000, 250, false);
        Vehiculo kawasaki = new Moto(Marca.KAWASAKI, 6000.59, 1000, true);
        vehiculos.add(kia);
        vehiculos.add(bmw);
        vehiculos.add(mercedes);
        vehiculos.add(ducati);
        vehiculos.add(yamaha);
        vehiculos.add(kawasaki);
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
            boolean correcto;
            do {
                System.out.println("******* INICIO *******");
                int opcion = sc.pedirNumero("1. Registro" +
                        "\n2. Inicio Sesion" +
                        "\n3. Atrás" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        registrar();
                        correcto = true;
                        break;
                    case 2:
                        iniciar();
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
    }

    private static void iniciar() {
        boolean correcto;
        do {
            try {
                System.out.println("¿Como quiere iniciar Sesión?");
                int opcion = sc.pedirNumero("1. Cliente" +
                        "\n2. Empleado" +
                        "\n3. Atras" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        inicioCliente();
                        correcto = true;
                        break;
                    case 2:
                        inicioEmpleado();
                        correcto = true;
                        break;
                    case 3:
                        correcto = true;
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } catch (HerenciaException e) {
                System.out.println(e.getMessage());
                correcto = false;
            }
        } while (!correcto);
    }

    private static void menuEmpleado(Empleado empleado) {
        boolean correcto;
        do {
            System.out.printf("******* MENU EMPLEADO  %d *******", empleado.getNum_empleado());
            int opcion = sc.pedirNumero("1. Ver Facturas" +
                    "\n2. Comprar Vehiculo" +
                    "\n3. Gestionar Vehiculos" +
                    "\n4. Cerrar Sesion" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    mostrarFacturas(empleado);
                    correcto = true;
                    break;
                case 2:

                    correcto = true;
                    break;
                case 3:
                    correcto = true;
                    break;
                case 4:
                    correcto = true;
                    break;
                default:
                    correcto = false;
                    break;
            }
        } while (!correcto);
    }

    private static void comprarVehiculo(Persona persona) {
        boolean correcto;
        do {
            mostrarVehiculos();
            char opcion = sc.pedirLetra("¿Quiere compar un vehiculo? Si (s) / No (n): ");
            switch (opcion) {
                case 's':
                case 'S':
                    correcto = true;
                    break;
                case 'n':
                case 'N':
                    correcto = true;
                    break;
                default:
                    correcto = false;
                    break;
            }

        } while (!correcto);

    }

    private static void mostrarFacturas(Persona persona) {
        for (Factura factura : facturas) {
            if (persona instanceof Empleado) {
                if (factura.getNum_empleado() == ((Empleado) persona).getNum_empleado()) {
                    System.out.println(factura);
                }
            } else if (persona instanceof Cliente) {
                if (factura.getNum_cliente() == ((Cliente) persona).getNum_cliente()) {
                    System.out.println(factura);
                }
            }
        }
    }

    private static void mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            System.out.println("******* MOSTRAR VEHICULOS *******");
            System.out.println("******* MOTOS *******");
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Moto) {
                    System.out.println(vehiculo);
                }
            }
            System.out.println("******* COCHES *******");
            for (Vehiculo vehiculo : vehiculos) {
                if (vehiculo instanceof Coche) {
                    System.out.println(vehiculo);
                }
            }
        } else {
            System.out.println("No existen vehiculos");
        }
    }

    private static void inicioCliente() throws HerenciaException {
        mostrarClientes();
        int opcion = sc.pedirNumero("Ingrese el numero del cliente: ");
        for (Persona persona : personas) {
            if (persona instanceof Cliente) {
                if (((Cliente) persona).getNum_cliente() == opcion) {
                    System.out.printf("Iniciando Sesion.... con cliente: %d", opcion);
                    return;
                }
            }
        }
        throw new HerenciaException("No existe un cliente con ese número.");
    }

    private static void inicioEmpleado() throws HerenciaException {
        mostrarEmpleados();
        int opcion = sc.pedirNumero("Ingrese el numero del empleado: ");
        for (Persona persona : personas) {
            if (persona instanceof Empleado) {
                if (((Empleado) persona).getNum_empleado() == opcion) {
                    System.out.printf("Iniciando Sesion.... con empleado: %d", opcion);
                    return;
                }
            }
        }
        throw new HerenciaException("No existe un empleado con ese número");
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
