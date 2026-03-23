package ampliacion.tercera_evaluacion.serializables;

public class MainPersistencia {

    private static final LibroDAO dao = new LibroDAO();

    public static void main(String[] args) {
//        Libro libro = new Libro("Prueba2", "Yo");
//        dao.guardar(libro);
        Libro libro = dao.cargar();
        System.out.println(libro);
    }
}
