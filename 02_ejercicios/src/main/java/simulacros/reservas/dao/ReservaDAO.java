package simulacros.reservas.dao;

import recursos.Utilidades;
import simulacros.reservas.models.Reserva;
import simulacros.reservas.models.enums.TipoHabitacion;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReservaDAO {
    private static final String RUTA = System.getProperty("user.home") + "/Desktop/DAM/Simulacros/Reservas/";
    private static final File FICHERO = new File(RUTA + "reservas.dat");

    public void guardar(Map<Reserva, TipoHabitacion> reservas) {

        if (comprobarDirectorio()) {

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {

                oos.writeObject(reservas);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Map<Reserva, TipoHabitacion> cargar() {
        Map<Reserva, TipoHabitacion> reservas = new LinkedHashMap<>();
        if (FICHERO.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {

                reservas = (Map<Reserva, TipoHabitacion>) ois.readObject();

            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return reservas;
    }


    private static boolean comprobarDirectorio() {
        if (Utilidades.existDirectory(RUTA)) {
            return true;
        } else {
            return Utilidades.crearDirectorio(RUTA);
        }
    }
}
