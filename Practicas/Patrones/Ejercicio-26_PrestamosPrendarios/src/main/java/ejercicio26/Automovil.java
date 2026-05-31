package ejercicio26;

import java.time.LocalDate;

public class Automovil extends Prenda{
    private static final double LIQUIDEZ = 0.7;
    private static final double PERDIDA_ANUAL = 0.10;

    private int modelo;
    private double kilometraje;
    private double costo0km;

    public Automovil(int m, double k, double c) {
        this.modelo = m;
        this.kilometraje = k;
        this.costo0km = c;
    }

    @Override
    public double getValor(){
        int antiguedad = Math.max(0, LocalDate.now().getYear() - modelo);   
        return costo0km * Math.pow(1 - PERDIDA_ANUAL, antiguedad);
    }

    @Override
    public double getLiquidez() {
        return LIQUIDEZ;
    }
}
