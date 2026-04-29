package ejercicio07;

public class CompraBonoAltoRiesgo extends Producto {
    private int parking;

    public CompraBonoAltoRiesgo(int parking) {
        super();
        this.parking = parking;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}