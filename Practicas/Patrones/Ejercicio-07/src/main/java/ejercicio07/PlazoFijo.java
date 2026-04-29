package ejercicio07;

public class PlazoFijo extends Producto {
    private int cantDias;
    private double interes;

    public PlazoFijo(int cantDias, double interes) {
        super();
        this.cantDias = cantDias;
        this.interes = interes;
    }

    @Override
    public double retornoInversion(double montoInicial) {
        return 0;
    }
}