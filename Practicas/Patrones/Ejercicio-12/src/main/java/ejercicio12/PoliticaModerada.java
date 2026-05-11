package ejercicio12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada extends  PoliticaCancelacion {
    @Override
    protected double calcularPenalizacion(LocalDate fecha) {
        long diasRestantes = ChronoUnit.DAYS.between(LocalDate.now(), fecha);
        if (diasRestantes >= 7)
            return 1;
        else if (diasRestantes >= 2)
            return 0.5;
        return 0;
    }
}
