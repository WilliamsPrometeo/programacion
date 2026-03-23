package ampliacion.tercera_evaluacion.serializables;

import recursos.Utilidades;

import java.io.*;

public class LibroDAO {

    private final String DIRECTORY = System.getProperty("user.home") + "/Desktop/DAW/Persistencia";
    private final File FILE = new File(DIRECTORY + File.separator + "libro.dat");

    public LibroDAO() {
        if (!Utilidades.existDirectory(DIRECTORY)) {
            Utilidades.crearDirectorio(DIRECTORY);
        }
    }

    public void guardar (Libro libro) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
            oos.writeObject(libro);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public Libro cargar () {
        Libro libro = null;

        if (FILE.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
                libro = (Libro) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }

        return libro;
    }
}
