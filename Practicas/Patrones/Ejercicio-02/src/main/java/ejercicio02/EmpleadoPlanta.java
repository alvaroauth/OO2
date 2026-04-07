package ejercicio02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoPlanta extends Empleado {
    private static final double SUELDO_BASICO = 50000.0;
    private static final double BONUS_ANTIGUEDAD = 2000.0;
    private static final double BONUS_CASADO = 5000.0;
    private static final double BONUS_HIJOS = 2000.0;
    private static final double COEF_DESC_BASICO = 0.13;
    private static final double COEF_DESC_ADICIONAL = 0.05;

    private LocalDate inicio;
    private boolean casado;
    private int cantHijos;

    public EmpleadoPlanta(String nombre, LocalDate inicio, boolean casado,  int cantHijos){
        super(nombre);
        this.inicio = inicio;
        this.casado = casado;
        this.cantHijos = cantHijos;
    }


    @Override
    protected double sueldoBasico() {
        return SUELDO_BASICO;
    }

    @Override
    protected double sueldoAdicional() {
        return (cantHijos * BONUS_HIJOS) + (ChronoUnit.YEARS.between(inicio,LocalDate.now()) * BONUS_ANTIGUEDAD) +((casado)? BONUS_CASADO : 0);
    }

    @Override
    protected double descuento() {
        return (this.sueldoBasico() * COEF_DESC_BASICO) + (this.sueldoAdicional() * COEF_DESC_ADICIONAL);
    }
}

