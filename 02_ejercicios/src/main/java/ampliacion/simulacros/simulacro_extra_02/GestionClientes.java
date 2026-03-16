package ampliacion.simulacros.simulacro_extra_02;

import recursos.MyScanner;
import recursos.Utilidades;

import java.io.*;
import java.util.ArrayList;

public class GestionClientes {

    private ArrayList<Cliente> clientes;
    private static final MyScanner sc = new MyScanner();
    private final String RUTA = System.getProperty("user.home") + "/Desktop/DAW/Simulacros/";

    public GestionClientes() {
        this.clientes = new ArrayList<>();
        if (!Utilidades.existDirectory(RUTA)) {
            Utilidades.crearDirectorio(RUTA);
        }
    }

    public void agregarCliente() {
        String id = getId();
        for (Cliente c: clientes) {
            if (c.getId().equals(id)) {
                System.out.println("El id ya está asociado a un cliente!");
                return;
            }
        }
        String nombre = sc.pideTexto("Introduce el nombre del cliente: ");
        String email = sc.pideTexto("Introduce el email del cliente: ");
        clientes.add(new Cliente(id, nombre, email));
        System.out.println("El cliente a sido registrado correctamente!");
    }

    public void mostrarClientes() {
        for (Cliente c: clientes) {
            System.out.println(c);
        }
    }

    public void guardarClientes() {
        File archivo = new File(RUTA, "clientes.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {

            for (Cliente c: clientes) {
                String linea = c.getId() + ";" + c.getNombre() + ";" + c.getEmail();
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Clientes guardados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cargarClientes() {
        File archivo = new File(RUTA, "clientes.txt");

        if (!archivo.exists()) {
            System.out.println("El archivo no existe");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                String id = datos[0];
                String nombre = datos[1];
                String email = datos[2];
                clientes.add(new Cliente(id, nombre, email));
            }

            System.out.println("Clientes cargados correctamente");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private String getId () {
        String regex = "^[A-Z]{2}[0-9]$";
        String id;
        do {
            id = sc.pideTexto("Introduce el id (2 letras y 1 número): ").toUpperCase();
        } while (!id.matches(regex));
        return id;
    }
}
