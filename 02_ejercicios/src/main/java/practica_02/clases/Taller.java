package practica_02.clases;

import practica_02.enums.TipoServicio;
import practica_02.enums.TipoVehiculo;
import practica_02.execptions.VehiculoNoEncontrado;
import recursos.MyScanner;
import recursos.Utilidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase Taller
 * Permite gestionar vehículos, servicios disponibles y los trabajos realizados sobre cada vehículo.
 *
 * @author Profesor - Williams
 * @version 2.0
 */
public class Taller {
    private static final MyScanner sc = new MyScanner();

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Servicio> catalogoServicios;
    private Map<Vehiculo, Servicio> trabajosRealizados;

    /**
     * Constructor vacio donde se inicializan las colecciones
     */
    public Taller() {
        vehiculos = new ArrayList<>();
        catalogoServicios = new ArrayList<>();
        trabajosRealizados = new LinkedHashMap<>();
    }

    /**
     * Getter del atributo vehiculos
     *
     * @return la coleccion de vehicuos
     */
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Setter del atributo vehiculos
     *
     * @param vehiculos establece la colección de vehiculos
     */
    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    /**
     * Getter del atributo catalogoServicios
     *
     * @return la colección de catalogoServicios
     */
    public ArrayList<Servicio> getCatalogoServicios() {
        return catalogoServicios;
    }

    /**
     * Setter del atributo catalogoServicios
     *
     * @param catalogoServicios establece la colección de catalogoServicios
     */
    public void setCatalogoServicios(ArrayList<Servicio> catalogoServicios) {
        this.catalogoServicios = catalogoServicios;
    }

    /**
     * Getter del atributo trabajosRealizados
     *
     * @return la colección de trabajos realizados
     */
    public Map<Vehiculo, Servicio> getTrabajosRealizados() {
        return trabajosRealizados;
    }

    /**
     * Setter del atributo trabajosRealizados
     *
     * @param trabajosRealizados establece la colección trabajosRealizados
     */
    public void setTrabajosRealizados(Map<Vehiculo, Servicio> trabajosRealizados) {
        this.trabajosRealizados = trabajosRealizados;
    }

    /**
     * Solicita al usuario los datos de un vehículo
     * y lo registra en la colección de vehículos del taller.
     *
     * La matrícula debe tener exactamente 7 caracteres
     * y el tipo de vehículo se selecciona mediante un menú.
     */

    public void registrarVehiculo() {
        String matricula;
        do {
            matricula = sc.pideTexto("Introduce la matricula: ");
            System.out.println(matricula.length() == 7 ? "Matricula correcta" : "La matricula tiene que tener 7 " +
                    "caracteres.");
        } while (matricula.length() != 7);
        String modelo = sc.pideTexto("Introduce el modelo: ");
        TipoVehiculo tipo = Utilidades.pedirEnum(TipoVehiculo.class, "Introduce el tipo de vehiculo");
        System.out.println("Vehiculo registrado correctamente!");
        vehiculos.add(new Vehiculo(matricula, modelo, tipo));
    }

    /**
     * Solicita al usuario los datos de un servicio
     * y lo añade al catálogo de servicios del taller.
     *
     * El tipo de servicio se selecciona mediante un menú.
     */

    public void registrarServicio() {
        String descripcion = sc.pideTexto("Introduce la descripción: ");
        String mecanico = sc.pideTexto("Introduce el nombre del mecánico: ");
        TipoServicio tipo = Utilidades.pedirEnum(TipoServicio.class, "Introduce el tipo de servicio");
        System.out.println("Servicio registrado correctamente!");
        catalogoServicios.add(new Servicio(descripcion, mecanico, tipo));
    }

    /**
     * Asigna un servicio existente a un vehículo registrado.
     *
     * Solicita la matrícula del vehículo y la descripción del servicio.
     * Si ambos existen, el servicio se asocia al vehículo y se registra
     * la fecha y hora de la asignación.
     */

    public void asignarServicio() {
        String matricula = sc.pideTexto("Introuce la matricula del vehiculo: ");
        Vehiculo vehiculo;
        try {
            vehiculo = buscarVehiculo(matricula);
        } catch (VehiculoNoEncontrado e) {
            System.out.println(e.getMessage());
            vehiculo = null;
        }
        if (vehiculo != null) {
            String descripcion = sc.pideTexto("Introduce la descripcion del servicio: ");
            Servicio servicio = buscarServicio(descripcion);
            System.out.println(servicio != null ? "Servicio encontrado" : "No existe ningun servicio con esa " +
                    "descripcion!");
            if (servicio != null) {
                trabajosRealizados.put(vehiculo, servicio);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                String fecha_formateada = LocalDateTime.now().format(formatter);
                System.out.printf("Servicio: %s asignado correctamente -> %s%n", servicio, fecha_formateada);
            }
        }
    }

    /**
     * Muestra todos los vehículos registrados en el taller.
     *
     * Permite al usuario filtrar los resultados por tipo de vehículo.
     */

    public void mostrarVehiculos() {
        Utilidades.imprimirLista(vehiculos);
        boolean correcto;
        do {
            correcto = true;
            char opcion = sc.pedirLetra("¿Quieres filtrar por tipo? (S / N): ");
            switch (opcion) {
                case 's':
                case 'S':
                    filtrar();
                    break;
                case 'n':
                case 'N':
                    break;
                default:
                    correcto = false;
                    break;
            }

        } while (!correcto);
    }

    /**
     * Muestra los vehículos filtrados por un tipo de vehículo
     * seleccionado por el usuario.
     */
    private void filtrar() {
        TipoVehiculo tipo = Utilidades.pedirEnum(TipoVehiculo.class, "Introduce el tipo de vehiculo");
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getTipo().equals(tipo)) {
                System.out.println(vehiculo);
            }
        }
    }

    /**
     * Muestra todos los servicios realizados junto
     * con el vehículo al que fueron asignados.
     */
    public void mostrarTrabajos() {
        System.out.println("---Trabajos realizados---");
        for (Vehiculo vehiculo : trabajosRealizados.keySet()) {
            System.out.printf("Servicio:%n %s %n realizado al vehiculo: %s%n", trabajosRealizados.get(vehiculo),
                    vehiculo);
        }
    }

    /**
     * Busca un vehículo en la colección a partir de su matrícula
     *
     * @param matricula Matrícula del vehículo que se desea buscar.
     * @return El objeto {@link Vehiculo} cuya matrícula coincide con la dada.
     * @throws VehiculoNoEncontrado Si no existe ningún vehículo con la matrícula proporcionada.
     */
    public Vehiculo buscarVehiculo(String matricula) throws VehiculoNoEncontrado {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) return vehiculo;
        }
        throw new VehiculoNoEncontrado("Vehiculo no encontrado!");
    }

    /**
     * Busca un servico en el catálogo a partir de su descripción
     *
     * @param descripcion Descripción del servicio que se desea buscar.
     * @return El objeto {@link Servicio} cuya descripción coincide con la dada,
     * o {@code null} si no se encuentra ningún servicio con dicha descripción.
     */
    public Servicio buscarServicio(String descripcion) {
        for (Servicio servicio : catalogoServicios) {
            if (servicio.getDescripcion().equals(descripcion)) return servicio;
        }
        return null;
    }
}
