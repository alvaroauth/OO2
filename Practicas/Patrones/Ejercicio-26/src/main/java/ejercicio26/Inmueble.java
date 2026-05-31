package ejercicio26;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Inmueble extends Prenda{
    private static final double LIQUIDEZ = 0.2;

    private String direccion;
    private double superficie;
    private double costom2;

    public Inmueble(String d, double s, double cm) {
        this.direccion = d;
        this.superficie = s;
        this.costom2 = cm;
    }

    @Override
    public double getValor(){
        return this.superficie *  this.costom2;
    }

    @Override
    public double getLiquidez() {
        return LIQUIDEZ;
    }
}
