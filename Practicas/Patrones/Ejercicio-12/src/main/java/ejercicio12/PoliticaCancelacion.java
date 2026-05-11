package ejercicio12;

import java.time.LocalDate;

public abstract class PoliticaCancelacion {

    public double calcularReembolso(double monto, LocalDate fecha){
        return monto * this.calcularPenalizacion(fecha);
    }

    protected abstract double calcularPenalizacion(LocalDate fecha);
}
