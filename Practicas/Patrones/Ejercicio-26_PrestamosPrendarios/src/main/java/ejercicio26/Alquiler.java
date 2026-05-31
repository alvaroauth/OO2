package ejercicio26;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Alquiler extends Prenda{
    private static final double LIQUIDEZ = 0.9;

    private LocalDate comienzoContrato;
    private LocalDate finContrato;
    private double costoMensual;

    public Alquiler(LocalDate comienzoContrato, LocalDate finContrato, double costoMensual) {
        this.comienzoContrato = comienzoContrato;
        this.finContrato = finContrato;
        this.costoMensual = costoMensual;
    }

    @Override
    public double getValor(){
        LocalDate desde = LocalDate.now().isAfter(comienzoContrato) ? LocalDate.now() : comienzoContrato;
        long mesesRestantes = ChronoUnit.MONTHS.between(desde, finContrato);
        return costoMensual * Math.max(0, mesesRestantes);
    }

    @Override
    public double getLiquidez() {
        return LIQUIDEZ;
    }
}
