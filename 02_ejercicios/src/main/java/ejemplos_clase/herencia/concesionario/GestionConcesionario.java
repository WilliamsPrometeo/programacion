package ejemplos_clase.herencia.concesionario;

import ejemplos_clase.herencia.clases.Persona;
import ejemplos_clase.herencia.concesionario.clases.*;
import ejemplos_clase.herencia.concesionario.enums.Marca;
import ejemplos_clase.herencia.exception.HerenciaException;
import recursos.MyScanner;

import java.util.ArrayList;

public class GestionConcesionario {

    private static final MyScanner sc = new MyScanner();
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static ArrayList<Factura> facturas = new ArrayList<>();
    private static int contador = 1;

    public static void main(String[] args) {
        rellenarVehiculos();
        menuPrincipal();
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
            int opcion = sc.pedirNumero("1. Inicio de Sesion" +
                    "\n2. Continuar" +
                    "\n3. Salir" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    registro();
                    break;
                case 2:
                    continuar();
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

    public static void continuar() {
        boolean correcto = false;
        do {
            System.out.println("******* PROMETEO CONCESSIONARIO *******");
            int opcion = sc.pedirNumero("1. Mostrar vehiculos" +
                    "\n2. Registrarse" +
                    "\n3. Atras" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    mostrarVehiculos();
                    break;
                case 2:
                    registro();
                    break;
                case 3:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
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
                        menuCliente(inicioCliente());
                        correcto = true;
                        break;
                    case 2:
                        menuEmpleado(inicioEmpleado());
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

    private static void menuCliente(Cliente cliente) {
        boolean correcto = false;
        do {
            System.out.printf("%n******* MENU CLIENTE  %d *******%n", cliente.getNum_cliente());
            int opcion = sc.pedirNumero("1. Ver Facturas" +
                    "\n2. Comprar Vehiculo" +
                    "\n3. Mostrar catalogo" +
                    "\n4. Cerrar Session" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    mostrarFacturas(cliente);
                    break;
                case 2:
                    comprarVehiculo(cliente);
                    break;
                case 3:
                    mostrarVehiculos();
                    break;
                case 4:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (!correcto);
    }

    private static void menuEmpleado(Empleado empleado) {
        boolean correcto = false;
        do {
            System.out.printf("%n******* MENU EMPLEADO  %d *******%n", empleado.getNum_empleado());
            int opcion = sc.pedirNumero("1. Ver Facturas" +
                    "\n2. Comprar Vehiculo" +
                    "\n3. Gestionar Vehiculos" +
                    "\n4. Cerrar Sesion" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    mostrarFacturas(empleado);
                    break;
                case 2:
                    comprarVehiculo(empleado);
                    break;
                case 3:
                    gestionVehiculo();
                    break;
                case 4:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (!correcto);
    }

    private static void gestionVehiculo() {
        boolean correcto = false;
        do {
            System.out.println("******* GESTION DE VEHICULO *******");
            int opcion = sc.pedirNumero("1. Agregar Vehiculo" +
                    "\n2. Eliminar Vehiculo" +
                    "\n3. Listar Vehiculos" +
                    "\n4. Atras." +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    agregarVehiculo();
                    break;
                case 2:
                    eliminarVehiculo();
                    break;
                case 3:
                    mostrarVehiculos();
                    break;
                case 4:
                    correcto = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (!correcto);
    }

    private static void eliminarVehiculo() {
        boolean correcto;
        do {
            mostrarVehiculos();
            int opcion = sc.pedirNumero("Ingrese el numero de vehiculo que desea eliminar: ");
            if (opcion < 0 || opcion > vehiculos.size()) {
                System.out.println("Opcion no valida.");
                correcto = false;
            } else {
                vehiculos.remove(opcion - 1);
                correcto = true;
            }
        } while (!correcto);
    }

    private static void agregarVehiculo() {
        boolean correcto;
        do {
            System.out.printf("%nIngrese la opcion del vehiculo a agregar:%n");
            int opcion = sc.pedirNumero("1. Coche" +
                    "\n2. Moto" +
                    "\n3. Atras" +
                    "\nOpcion: ");
            switch (opcion) {
                case 1:
                    vehiculos.add(agregarCoche());
                    correcto = true;
                    break;
                case 2:
                    vehiculos.add(agregarMoto());
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

    private static Coche agregarCoche() {
        boolean correcto;
        Marca marca = null;
        do {
            System.out.println("Ingrese la marca: ");
            int marcas = sc.pedirNumero("1. KIA,\n" +
                    "2. MERCEDES,\n" +
                    "3. FORD,\n" +
                    "4. AUDI,\n" +
                    "5. BMW" +
                    "\nOpcion: ");
            switch (marcas) {
                case 1:
                    marca = Marca.KIA;
                    correcto = true;
                    break;
                case 2:
                    marca = Marca.MERCEDES;
                    correcto = true;
                    break;
                case 3:
                    marca = Marca.FORD;
                    correcto = true;
                    break;
                case 4:
                    marca = Marca.AUDI;
                    correcto = true;
                    break;
                case 5:
                    marca = Marca.BMW;
                    correcto = true;
                    break;
                default:
                    System.out.printf("Ingrese una opcion correcta.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        double precio = sc.pedirDecimal("Ingrese el precio: ");
        int num_puertas = sc.pedirNumero("Ingrese el numero de puertas: ");
        boolean airbags = false;
        do {
            char opcion = sc.pedirLetra("¿Tiene airbags? Si (s) / No (n): ");
            switch (opcion) {
                case 's':
                case 'S':
                    airbags = true;
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

        return new Coche(marca, precio, num_puertas, airbags);
    }

    private static Moto agregarMoto() {
        boolean correcto;
        Marca marca = null;
        do {
            System.out.println("Ingrese la marca: ");
            int marcas = sc.pedirNumero("1.DUCATI,\n" +
                    "2. YAMAHA,\n" +
                    "3. KAWASAKI,\n" +
                    "4. HONDA," +
                    "\nOpcion: ");
            switch (marcas) {
                case 1:
                    marca = Marca.DUCATI;
                    correcto = true;
                    break;
                case 2:
                    marca = Marca.YAMAHA;
                    correcto = true;
                    break;
                case 3:
                    marca = Marca.KAWASAKI;
                    correcto = true;
                    break;
                case 4:
                    marca = Marca.HONDA;
                    correcto = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta.");
                    correcto = false;
                    break;
            }
        } while (!correcto);
        double precio = sc.pedirDecimal("Ingrese el precio: ");
        int cilindrada = sc.pedirNumero("Ingrese el numero de cilindrada: ");
        boolean sidecar = false;
        do {
            char opcion = sc.pedirLetra("¿Tiene sidecar? Si (s) / No (n): ");
            switch (opcion) {
                case 's':
                case 'S':
                    sidecar = true;
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
        return new Moto(marca, precio, cilindrada, sidecar);
    }

    private static void comprarVehiculo(Persona persona) {
        boolean correcto;
        do {
            char opcion = sc.pedirLetra("¿Quiere compar un vehiculo? Si (s) / No (n): ");
            switch (opcion) {
                case 's':
                case 'S':
                    establecerCompra(persona);
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

    private static void establecerCompra(Persona persona) {
        if (persona instanceof Empleado) {
            boolean cancelar = false;
            while (!cancelar) {
                System.out.println("Al ser empleado tiene un descuento del 15% en la compra.");
                mostrarVehiculos();
                int opcion = sc.pedirNumero("Selecciona el vehículo que deseas comprar (Digite -1 si quiere cancelar): ");
                if (opcion == -1) {
                    cancelar = true;
                } else if (opcion <= 0 || opcion > vehiculos.size()) {
                    System.out.println("Opción de vehiculo no válida");
                } else {
                    Vehiculo vehiculo = vehiculos.get(opcion - 1);
                    persona.addVehiculo(vehiculo);
                    vehiculos.remove(vehiculo);
                    Factura factura = new Factura(contador, ((Empleado) persona).getNum_empleado(), ((Empleado) persona).getNum_empleado(), vehiculo);
                    contador++;
                    facturas.add(factura);
                    System.out.println("Vehiculo comprado en la compra: " + vehiculo.mostrar());
                    System.out.println("Se eliminará del concesionario.");
                    cancelar = true;
                }
            }
        } else if (persona instanceof Cliente) {
            boolean cancelar = false;
            while (!cancelar) {
                mostrarVehiculos();
                int opcion = sc.pedirNumero("Selecciona el vehículo que deseas comprar (Digite -1 si quiere cancelar): ");
                if (opcion == -1) {
                    cancelar = true;
                } else if (opcion <= 0 || opcion > vehiculos.size()) {
                    System.out.println("Opción de vehiculo no válida");
                } else {
                    boolean existe;
                    int num_empleado;
                    do {
                        mostrarEmpleados();
                        num_empleado = sc.pedirNumero("Indique el número del empleado que le ha vendido el coche: \nEn caso de que no le haya atendido nadie, digite un 0.");
                        if (num_empleado < 0) {
                            System.out.println("No puede digitar una opcion negativa.");
                            existe = false;
                        } else {
                            Empleado empleado_recuperado = null;
                            if (num_empleado != 0) {
                                for (Persona empleado : personas) {
                                    if (empleado instanceof Empleado && ((Empleado) empleado).getNum_empleado() == num_empleado) {
                                        empleado_recuperado = (Empleado) empleado;
                                        break;
                                    }
                                }
                                if (empleado_recuperado == null) {
                                    System.out.println("No existe el empleado en la lista.");
                                    existe = false;
                                } else {
                                    existe = true;
                                }
                            } else {
                                existe = true;
                            }
                        }

                    } while (!existe);

                    Vehiculo vehiculo = vehiculos.get(opcion - 1);
                    persona.addVehiculo(vehiculo);
                    vehiculos.remove(vehiculo);
                    Factura factura = new Factura(contador, ((Cliente) persona).getNum_cliente(), num_empleado, vehiculo);
                    contador++;
                    facturas.add(factura);
                    System.out.println("Vehiculo comprado en la compra: " + vehiculo.mostrar());
                    System.out.println("Se eliminará del concesionario.");
                    cancelar = true;
                }
            }
        }
    }

    private static void mostrarFacturas(Persona persona) {
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas que mostrar.");
        } else {
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

    }

    private static void mostrarVehiculos() {
        if (!vehiculos.isEmpty()) {
            System.out.println("******* MOSTRAR VEHICULOS *******");
            for (int i = 0; i < vehiculos.size(); i++) {
                System.out.printf("%d. %s %n", i + 1, vehiculos.get(i).mostrar());
            }
        } else {
            System.out.println("No existen vehiculos");
        }
    }

    private static Cliente inicioCliente() throws HerenciaException {
        mostrarClientes();
        int opcion = sc.pedirNumero("Ingrese el numero del cliente: ");
        for (Persona persona : personas) {
            if (persona instanceof Cliente) {
                if (((Cliente) persona).getNum_cliente() == opcion) {
                    System.out.printf("Iniciando Sesion.... con cliente: %d", opcion);
                    return (Cliente) persona;
                }
            }
        }
        throw new HerenciaException("No existe un cliente con ese número.");
    }

    private static Empleado inicioEmpleado() throws HerenciaException {
        mostrarEmpleados();
        int opcion = sc.pedirNumero("Ingrese el numero del empleado: ");
        for (Persona persona : personas) {
            if (persona instanceof Empleado) {
                if (((Empleado) persona).getNum_empleado() == opcion) {
                    System.out.printf("Iniciando Sesion.... con empleado: %d%n", opcion);
                    return (Empleado) persona;
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
