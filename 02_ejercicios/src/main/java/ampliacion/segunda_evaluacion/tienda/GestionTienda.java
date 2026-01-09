package ampliacion.segunda_evaluacion.tienda;


import recursos.MyScanner;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GestionTienda {

    private static final MyScanner sc =  new MyScanner();

    public static void main(String[] args) {
        Map<Producto, Integer> stock = new LinkedHashMap<>();

        Producto pan = new Producto("Pan", 0.5);
        stock.put(pan, 5);

        Producto leche =  new Producto("Leche", 1.5);
        stock.put(leche, 10);

        stock.put(pan, 10);

        System.out.println(stock);

//        for (Map.Entry<Producto, Integer> entry : stock.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println("Stock: "+entry.getValue());
//        }
//
//        for (Producto producto : stock.keySet()) {
//            System.out.println(stock.get(producto));
//        }
    }

}
