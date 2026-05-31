package ejercicio26;

import java.util.List;

public class Combinado extends Prenda{
    private static final double LIQUIDEZ = 0.5;

    private List<Prenda> prendas;

    public Combinado(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    @Override
    public double getValor() {
        return this.prendas.stream().mapToDouble(Prenda::getValor).sum();
    }

    @Override
    public double getLiquidez() {
        return LIQUIDEZ;
    }
}
