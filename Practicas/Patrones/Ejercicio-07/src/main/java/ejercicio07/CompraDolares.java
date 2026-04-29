package ejercicio07;

public class CompraDolares extends Producto {
    private double valorCompra;

    public CompraDolares(double valorCompra) {
        super();
        this.valorCompra = valorCompra;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}