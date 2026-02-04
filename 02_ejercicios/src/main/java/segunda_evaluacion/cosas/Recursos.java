package segunda_evaluacion.cosas;

import java.util.List;

public class Recursos {

    public static <T> void mostrar(T objeto) {
        System.out.println(objeto.getClass().getName());
    }

    public static void mostrarLista(List<?> lista) {
        for (Object objeto : lista) {
            System.out.println(objeto);
        }
    }
}
