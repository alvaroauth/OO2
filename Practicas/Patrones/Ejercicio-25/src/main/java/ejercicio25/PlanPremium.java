package ejercicio25;

public class PlanPremium extends PlanMedico {
    private static final double MONTO_FIJO = 33000.0;
    private static final double CARGO_FAMILIAR = 2800.0;

    @Override
    protected double getMontoFijo(ICoseguro coseguro) {
        return MONTO_FIJO - coseguro.getDescuento();
    }

    @Override
    protected double getCargoFamiliar(Afiliado a) {
        return (a.getFamiliaresACargo() > 4)? (a.getFamiliaresACargo()- 4)*CARGO_FAMILIAR : 0;
    }

    @Override
    protected double getCostoCobertura(Afiliado a) {
        return (a.getSalario() * 0.01) - a.getCoseguro().getMontoCoberturaViajes();
    }

    @Override
    protected double getSeguroInternacion() {
        return MONTO_FIJO * 0.05;
    }
}