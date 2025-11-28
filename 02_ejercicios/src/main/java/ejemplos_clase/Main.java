package ejemplos_clase;

import ciudad.tienda.GestionTienda;
import ciudad.tienda.clases.StockTienda;
import recursos.MyScanner;

import java.util.ArrayList;

public class Main {
    private static final MyScanner sc = new MyScanner();

    public static void main(String[] args) {

        GestionTienda gestion =  new GestionTienda();
        gestion.menu();

        ArrayList<StockTienda> tiendas = gestion.getTiendas();

        for (StockTienda key : tiendas) {
            System.out.println(key.toString());
        }
    }

}
