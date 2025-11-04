package gestion_parking;

import recursos.MyScanner;
import gestion_parking.clases.Parking;
import gestion_parking.clases.Vehiculos;
import gestion_parking.exceptions.ParkingException;

public class GestionParking {
    private static final MyScanner sc =  new MyScanner();
    private static final Parking parking = new Parking();

    public static void main(String[] args){
        menu();
    }

    public static void menu() {
        boolean exit = false;
        while(!exit){
            System.out.println("***** Parking Menu *****");
            System.out.println("\t1. Registrar Vehiculo");
            System.out.println("\t2. Listar Vehiculos");
            System.out.println("\t3. Eliminar Vehiculo");
            System.out.println("\t0. Salir");
            int opcion = sc.pedirNumero("Ingrese una opcion: ");
            exit = acciones(opcion);
        }
    }

    public static boolean acciones(int opcion){
        switch(opcion){
            case 1:
                parking.registrarVehiculo(pedirVehiculo());
            break;
            case 2:
                parking.listarVehiculo();
            break;
            case 3:
                if (eliminarVehiculo()) {
                    System.out.println("El vehiculo ha sido eliminado exitosamente.");
                } else {
                    System.out.println("Fallo al eliminar el vehículo.");
                }
            break;
            case 0:
                System.out.println("***** Saliendo *****");
                return true;
            default:
                System.out.println("Opcion no valida");
            break;
        }

        return false;
    }

    public static Vehiculos pedirVehiculo(){
//        Vehiculos vehiculo = new Vehiculos();
        String matricula = sc.pideTexto("Ingrese la matricula: ");
//        vehiculo.setMatricula(matricula);
        String marca = sc.pedirSoloTexto("Ingrese la marca: ");
//        vehiculo.setMarca(marca);
        Vehiculos vehiculo = new Vehiculos(matricula, marca);
        return vehiculo;
    }

    public static boolean eliminarVehiculo(){
        parking.listarVehiculo();
        int id = sc.pedirNumero("Ingrese el id del vehiculo: ");
        try {
            return parking.eliminarPorId(id);
        } catch (ParkingException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
