package ampliacion.gestion_peliculas;

import java.util.ArrayList;

public class Filmoteca {
    private ArrayList<Pelicula> catalogo;

    public Filmoteca() {
        catalogo = new ArrayList<>();
    }

    public ArrayList<Pelicula> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Pelicula> catalogo) {
        this.catalogo = catalogo;
    }

    public void añadirPelicula(Pelicula pelicula) {
        catalogo.add(pelicula);
    }

    public void listarPeliculas() {
        for (Pelicula pelicula : catalogo) {
            System.out.println(pelicula);
        }
    }

    public void bucarPorDuracion(int minimo, int maximo) {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getDuracion() >= minimo && pelicula.getDuracion() <= maximo) {
                System.out.println(pelicula);
            }
        }
    }

    public void buscarPorDirector(String director) {
        for (Pelicula pelicula : catalogo) {
            if (pelicula.getDirector().equals(director)) {
                System.out.println(pelicula);
            }
        }
    }

}
