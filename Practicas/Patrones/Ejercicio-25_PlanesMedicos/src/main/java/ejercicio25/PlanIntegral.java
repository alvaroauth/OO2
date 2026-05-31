package ejercicio25;

public class PlanIntegral extends  PlanMedico {
    private static final double MONTO_FIJO = 22000.0;
    private static final double CARGO_FAMILIAR = 3000.0;
    private static final double DESCUENTO_ANTIGUEDAD = 10000.0;

    @Override
    protected double getMontoFijo(ICoseguro coseguro) {
        return MONTO_FIJO;
    }

    @Override
    protected double getCargoFamiliar(Afiliado a) {
        return (a.getFamiliaresACargo() * CARGO_FAMILIAR) + (a.getSalario() * 0.01);
    }

    @Override
    protected double getCostoCobertura(Afiliado a) {
        double sal = a.getSalario() * 0.03, seg = a.getCoseguro().getAntiguedad() * DESCUENTO_ANTIGUEDAD;
        return (sal - seg > 0)? sal - seg : 0;
    }

    @Override
    protected double getSeguroInternacion() {
        return MONTO_FIJO * 0.05;
    }
}
