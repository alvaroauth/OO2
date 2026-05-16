package ejercicio07;

public class CompraPesos extends Producto {
        private double valorCompra;

        public CompraPesos(double valorCompra) {
                super();
                this.valorCompra = valorCompra;
        }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}