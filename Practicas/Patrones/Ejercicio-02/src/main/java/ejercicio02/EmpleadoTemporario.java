package ejercicio02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class EmpleadoTemporario extends Empleado {
    private static final double SUELDO_BASICO = 20000.0;
    private static final double BONUS_EXAMEN= 2000.0;
    private static final double COEF_DESC_BASICO = 0.13;
    private static final double COEF_DESC_ADICIONAL = 0.05;

    private int cantExamenes;

    public EmpleadoTemporario(String nombre, int cantExamenes){
        super(nombre);
        this.cantExamenes = cantExamenes;
    }

    @Override
    protected double sueldoBasico() {
        return SUELDO_BASICO;
    }

    @Override
    protected double sueldoAdicional() {
        return (cantExamenes * BONUS_EXAMEN);
    }

    @Override
    protected double descuento() {
        return (this.sueldoBasico() * COEF_DESC_BASICO) + (this.sueldoAdicional() * COEF_DESC_ADICIONAL);
    }
}

