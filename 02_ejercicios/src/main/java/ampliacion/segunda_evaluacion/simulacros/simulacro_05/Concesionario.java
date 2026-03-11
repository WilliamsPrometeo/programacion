package ampliacion.segunda_evaluacion.simulacros.simulacro_05;

import ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases.Coche;
import ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases.Moto;
import ampliacion.segunda_evaluacion.simulacros.simulacro_05.clases.Vehiculo;
import recursos.MyScanner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Concesionario {

    private static final MyScanner sc = new MyScanner();

    private static ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
    private static Map<Vehiculo, Integer> stockVehiculos = new LinkedHashMap<>();

    public static void main(String[] args) {
        Moto moto = new Moto("","","",0.0,1);
    }

    public boolean agregarVehiculo() {
        String matricula = getMatricula();
        Vehiculo v = getVehiculo(matricula);
        if (v != null) {
            stockVehiculos.put(v, stockVehiculos.get(v)+1);
            return false;
        } else {
            String marca = sc.pideTexto("Introduce la marca del vehiculo: ");
            String modelo = sc.pideTexto("Introduce el modelo del vehiculo: ");
            double precio = sc.pedirDecimal("Introduce el precio del vehiculo: ");
            boolean correcto;
            do {
                correcto = true;
                int opcion = sc.pedirNumero("Seleccione opcion:" +
                        "\n1. Coche" +
                        "\n2. Moto" +
                        "\nOpcion: ");
                switch (opcion) {
                    case 1:
                        Vehiculo coche = new Coche(matricula, marca, modelo, precio,
                                sc.pedirNumero("Introduce el numero de puertas: "));
                        listaVehiculos.add(coche);
                        stockVehiculos.put(coche, 1);
                        break;
                    case 2:
                        Vehiculo moto = new Moto(matricula, marca, modelo, precio,
                                sc.pedirNumero("Introduce la cilindrada: "));
                        listaVehiculos.add(moto);
                        stockVehiculos.put(moto, 1);
                        break;
                    default:
                        correcto = false;
                        break;
                }
            } while (!correcto);
            return true;
        }
    }

    public void consultarStock() {
        for (Map.Entry<Vehiculo, Integer> mapa : stockVehiculos.entrySet()) {
            Vehiculo v = mapa.getKey();
            Integer valor = mapa.getValue();
            System.out.println(v + " Stock: " + valor);
        }
    }

    public void mostraVehiculos() {
        for (Vehiculo v : listaVehiculos) {
            System.out.println(v.mostrarInformacion());
        }
    }

    public boolean reducirStock() {
        String matricula = getMatricula();
        Vehiculo v = getVehiculo(matricula);
        if (v != null) {
            int nuevoStock = stockVehiculos.get(v);
            if (nuevoStock - 1 == 0) {
                stockVehiculos.remove(v);
                listaVehiculos.remove(v);
            } else {
                stockVehiculos.put(v, stockVehiculos.get(v)-1);
            }
            return true;
        }
        return false;
    }

    private static Vehiculo getVehiculo(String matricula) {
        for (Vehiculo vehiculo : listaVehiculos){
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo;
            }
        }
        return null;
    }

    private static String getMatricula() {
        String regex = "^[1-9]{4}[A-Z]{3}$";
        String matricula;

        do {
            matricula = sc.pideTexto("Introduce la matricula: ").toUpperCase();
        } while (!matricula.matches(regex));

        return matricula;
    }
}
