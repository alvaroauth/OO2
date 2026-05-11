package ejercicio12;

import java.time.LocalDate;

public class PoliticaFlexible extends PoliticaCancelacion{
    @Override
    protected double calcularPenalizacion(LocalDate fecha) {
        if (LocalDate.now().isAfter(fecha)) {
            return 0;
        }
        return 1;
    }
}
