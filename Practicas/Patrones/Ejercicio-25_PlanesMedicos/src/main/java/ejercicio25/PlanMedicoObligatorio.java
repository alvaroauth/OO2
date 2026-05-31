package ejercicio25;

public class PlanMedicoObligatorio extends  PlanMedico {
    private static final double MONTO_FIJO = 15000.0;
    private static final double CARGO_FAMILIAR = 3500.0;

    @Override
    protected double getMontoFijo(ICoseguro coseguro) {
        return MONTO_FIJO;
    }

    @Override
    protected double getCargoFamiliar(Afiliado a) {
        return (a.getFamiliaresACargo() - a.getCoseguro().getDescuento()) * CARGO_FAMILIAR;
    }

    @Override
    protected double getCostoCobertura(Afiliado a) {
        return (a.getSalario() * 0.01) - a.getCoseguro().getMontoCoberturaViajes();
    }

    @Override
    protected double getSeguroInternacion() {
        return 0;
    }
}
