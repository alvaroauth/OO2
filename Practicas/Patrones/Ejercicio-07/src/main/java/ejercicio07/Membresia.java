package ejercicio07;

import java.util.ArrayList;
import java.util.List;

public abstract class Membresia {
    public ProductoCombinado armarProducto1(double montoDolares, double montoPesos){
        List<Producto> lista = new ArrayList<>();
        lista.add(new CompraDolares(montoDolares));
        lista.add(new PlazoFijo(getDiasMinimo(), getInteres()));
        lista.add(new CompraPesos(montoPesos));
        return new ProductoCombinado(lista);
    }
    public ProductoCombinado armarProducto2(double montoDolares, double montoPesos){
        List<Producto> lista = new ArrayList<>();
        lista.add(new CompraBonoAltoRiesgo(getParking()));
        lista.add(new CompraDolares(montoDolares));
        lista.add(new PlazoFijo(getDiasMinimo(), getInteres()));
        lista.add(new CompraPesos(montoPesos));
        return new ProductoCombinado(lista);
    }

    public ProductoCombinado armarProducto3(){
        throw new UnsupportedOperationException("No se puede armar el producto 3 siendo Silver");
    }

    public ProductoCombinado armarProducto4(){
        throw new UnsupportedOperationException("No se puede armar el producto 3 con la membresia actual");
    }

    protected abstract int getDiasMinimo();
    protected abstract double getInteres();
    protected abstract int getParking();
}
