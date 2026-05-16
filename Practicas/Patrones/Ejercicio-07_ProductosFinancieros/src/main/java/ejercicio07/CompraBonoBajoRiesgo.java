package ejercicio07;

public class CompraBonoBajoRiesgo extends Producto {
    private int parking;

    public CompraBonoBajoRiesgo(int parking) {
        super();
        this.parking = parking;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}