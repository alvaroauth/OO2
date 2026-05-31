package ejercicio25;

public class NullCoseguro implements ICoseguro{
    @Override
    public double getDescuento() {
        return 0;
    }

    @Override
    public int getAntiguedad() {
        return 0;
    }

    @Override
    public double getMontoCoberturaViajes() {
        return 0;
    }
}
