package ciudad.banco;

import ciudad.banco.clases.Banco;
import ciudad.banco.clases.Cuenta;
import ciudad.banco.clases.EmpleadoBanco;
import ciudad.banco.enums.Divisa;
import ciudad.banco.enums.TipoBanco;
import ciudad.clases.Cliente;
import recursos.MyScanner;

import java.util.ArrayList;

/**
 * Controlador GestionBanco
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class GestionBanco {
    private static final MyScanner sc = new MyScanner();
    private static Banco banco;
    private static ArrayList<EmpleadoBanco> empleados = new ArrayList<>();
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int num_cuenta = 111;

    public GestionBanco() {
        empleados = inicializarEmpleados();
    }

    private static ArrayList<EmpleadoBanco> inicializarEmpleados() {
        ArrayList<EmpleadoBanco> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(new EmpleadoBanco("Pepe", "Gonzalez", 30, 1234, TipoBanco.BBVA));
        listaEmpleados.add(new EmpleadoBanco("Juan", "Perez", 50, 1235, TipoBanco.BANKINTER));
        listaEmpleados.add(new EmpleadoBanco("Adam", "Perez", 20, 1111, TipoBanco.BNP_PARIBAS));
        listaEmpleados.add(new EmpleadoBanco("Cristiano", "Ronaldo", 48, 7777, TipoBanco.SANTANDER));
        return listaEmpleados;
    }

    public void inicioSesionEmpleado() {
        boolean correcto;
        EmpleadoBanco empleado;
        do {
            empleado = inicioEmpleado();
            if (empleado == null) {
                System.out.println("No existe el empleado");
                correcto = false;
            } else {
                correcto = true;
            }
        } while (!correcto);
        menuEmpleado(empleado, clientes);
    }

    public ArrayList<EmpleadoBanco> getEmpleados() {
        return empleados;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    private static EmpleadoBanco inicioEmpleado() {

        for (EmpleadoBanco emp : empleados) {
            System.out.println(emp);
        }
        int num_empleado = sc.pedirNumero("Ingrese el numero de empleado: ");
        for (EmpleadoBanco emp : empleados) {
            if (emp.getNum_empleado() == num_empleado) {
                return emp;
            }
        }

        return null;
    }

    private static void menuEmpleado(EmpleadoBanco empleado, ArrayList<Cliente> clientes) {
        boolean correcto;
        Cliente cliente;
        do {
            System.out.printf("======Menu empleado %d======", empleado.getNum_empleado());
            int opcion = sc.pedirNumero("1. Gestionar cliente" +
                    "\n2. Cerrar Sesion" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    do {
                        cliente = elegirCliente(clientes);
                        if (cliente != null) {
                            correcto = true;
                        } else {
                            System.out.println("El cliente no existe");
                            correcto = false;
                        }
                    } while (!correcto);
                    gestionCliente(cliente);
                    correcto = false;
                    break;
                case 2:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    correcto = false;
                    break;
            }

        } while (!correcto);
    }

    private static void menuEmpleado(EmpleadoBanco empleado, Cliente cliente) {
        boolean correcto = false;
        do {
            System.out.printf("======Menu empleado %d======", empleado.getNum_empleado());
            int opcion = sc.pedirNumero("1. Gestionar cliente" +
                    "\n2. Cerrar Sesion" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    gestionCliente(cliente);
                    break;
                case 2:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (!correcto);
    }

    public void gestionCliente(EmpleadoBanco empleado, Cliente cliente) {
        if (empleado!= null && cliente!=null) {
            menuEmpleado(empleado, cliente);
        } else {
            System.out.println("Datos introducidos incorrectos.");
        }
    }

    private static void gestionCliente(Cliente cliente) {
        boolean correcto;
        do {
            System.out.printf("=====Gestionando Cliente: %d=====", cliente.getNum_cliente());
            int opcion = sc.pedirNumero("1. Agregar cuenta" +
                    "\n2. Eliminar cuenta" +
                    "\n3. Atras" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    addCuenta(cliente);
                    correcto = true;
                    break;
                case 2:
                    deleteCuenta(cliente);
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

    private static Cliente elegirCliente(ArrayList<Cliente> clientes) {

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        int num_cliente = sc.pedirNumero("Ingresa el numero del cliente: ");
        for (Cliente cliente : clientes) {
            if (cliente.getNum_cliente() == num_cliente) {
                return cliente;
            }
        }
        return null;
    }

    private static void deleteCuenta(Cliente cliente) {
        System.out.println("Eliminando cuenta del cliente: " + cliente.getNum_cliente());
        cliente.setCuenta(null);
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

    public void gestionarCuenta(Cuenta cuenta) {
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
