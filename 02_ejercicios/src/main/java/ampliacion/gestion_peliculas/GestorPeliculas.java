package ampliacion.gestion_peliculas;

/*
    Alumno - nombre y apellido
    DAW - Ampliacion de Programacion
    20/11/2025
 */

public class GestorPeliculas {
    public static void main(String[] args) {
        Filmoteca filmoteca = new Filmoteca();
        Pelicula pelicula1 = new Pelicula("Interestelar", "Nolan", 280);
        Pelicula pelicula2 = new Pelicula("El señor de los anillos", "Peter", 180);
        Pelicula pelicula3 = new Pelicula("Openhaimer", "Nolan", 180);
        Pelicula pelicula4 = new Pelicula("El padrino", "Francis", 175);

        filmoteca.añadirPelicula(pelicula1);
        filmoteca.añadirPelicula(pelicula2);
        filmoteca.añadirPelicula(pelicula3);
        filmoteca.añadirPelicula(pelicula4);

        System.out.println("====Catalogo de peliculas====");
        filmoteca.listarPeliculas();

        System.out.println("====Peliculas entre 180 y 300 min=====");
        filmoteca.bucarPorDuracion(180, 300);

        System.out.println("====Peliculas de Nolan=====");
        filmoteca.buscarPorDirector("Nolan");

    }
}
