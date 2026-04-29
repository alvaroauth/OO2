package ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class ProductoCombinado extends Producto {
    private List<Producto> productos;

    public ProductoCombinado(List<Producto> productos) {
        super();
        this.productos = new ArrayList<>(productos);
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}