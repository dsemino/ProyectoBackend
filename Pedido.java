
package techlab.inicio;

import techlab.inicio.Producto;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int SIGUIENTE_ID = 1;
    private int id;

    private double total;
    

    public int getId() {
        return id;
    }



    public double getTotal() {
        return total;
    }

}

