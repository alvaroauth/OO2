package ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class Gold extends Membresia{
    private static final double TASA_PF = 0.06;
    private static final int DIAS_MIN_PF = 30;
    private static final int PARKING_MIN_HS = 24;

    @Override
    public ProductoCombinado armarProducto3() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new CompraBonoAltoRiesgo(PARKING_MIN_HS));
        lista.add(new CompraBonoBajoRiesgo(PARKING_MIN_HS));
        lista.add(new PlazoFijo(DIAS_MIN_PF, TASA_PF));
        return  new ProductoCombinado(lista);
    }

    @Override
    public ProductoCombinado armarProducto4() {
        List<Producto> lista = new ArrayList<>();
        lista.add(new CompraBonoAltoRiesgo(PARKING_MIN_HS));
        lista.add(new CompraBonoBajoRiesgo(PARKING_MIN_HS));
        lista.add(new CompraBonoAltoRiesgo(PARKING_MIN_HS));
        return new ProductoCombinado(lista);
    }

    @Override
    protected int getDiasMinimo() {
        return DIAS_MIN_PF;
    }

    @Override
    protected double getInteres() {
        return TASA_PF;
    }

    @Override
    protected int getParking() {
        return PARKING_MIN_HS;
    }
}
