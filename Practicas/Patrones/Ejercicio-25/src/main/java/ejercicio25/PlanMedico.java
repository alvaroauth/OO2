package ejercicio25;

import java.time.LocalDate;

public abstract class PlanMedico {
    private LocalDate fechaContratacion;

    public double getCostoMensual(Afiliado a){
        return this.getMontoFijo(a.getCoseguro())
                + this.getCargoFamiliar(a)
                + this.getCostoCobertura(a)
                + this.getSeguroInternacion();
    }

    protected abstract double getMontoFijo(ICoseguro coseguro);
    protected abstract double getCargoFamiliar(Afiliado a);
    protected abstract double getCostoCobertura(Afiliado a);
    protected abstract double getSeguroInternacion();
}
