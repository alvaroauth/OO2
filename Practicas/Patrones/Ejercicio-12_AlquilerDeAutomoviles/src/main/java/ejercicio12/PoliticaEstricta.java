package ejercicio12;

import java.time.LocalDate;

public class PoliticaEstricta extends PoliticaCancelacion{
    @Override
    protected double calcularPenalizacion(LocalDate fecha) {
        return 0;
    }
}
