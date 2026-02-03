package primera_evaluacion.ciudad.tienda.clases;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase StockTienda
 *
 * @author Profesor - Williams
 * @version 1.0
 */
public class StockTienda {
    private Tienda tienda;
    private Map<Producto, Integer> stock;

    public StockTienda(Tienda tienda) {
        this.tienda = tienda;
        this.stock = new HashMap<>();
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Map<Producto, Integer> getStock() {
        return stock;
    }

    public void setStock(Map<Producto, Integer> stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        String stockFormated = "";
        for (Producto key : stock.keySet()) {
            stockFormated = stockFormated.concat("\n\t - " + key.toString() + " | Stock: " + stock.get(key));
        }
        return String.format("Tienda %s, %nStock Productos: {%s%n}", tienda.getNombre(), stockFormated);
    }
}
