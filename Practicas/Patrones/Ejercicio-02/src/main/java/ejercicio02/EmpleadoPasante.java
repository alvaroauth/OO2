package ejercicio02;

public class EmpleadoPasante extends Empleado {
    private static final double SUELDO_BASICO = 20000.0;
    private static final double BONUS_HORAS = 300.0;
    private static final double BONUS_CASADO = 5000.0;
    private static final double BONUS_HIJOS = 2000.0;
    private static final double COEF_DESC_BASICO = 0.13;
    private static final double COEF_DESC_ADICIONAL = 0.05;

    private double horasTrabajadas;
    private boolean casado;
    private int cantHijos;

    public EmpleadoPasante(String nombre, double horasTrabajadas, boolean casado,  int cantHijos){
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.casado = casado;
        this.cantHijos = cantHijos;
    }


    @Override
    protected double sueldoBasico() {
        return SUELDO_BASICO + this.horasTrabajadas * BONUS_HORAS;
    }

    @Override
    protected double sueldoAdicional() {
        return (cantHijos * BONUS_HIJOS) + ((casado)? BONUS_CASADO : 0);
    }

    @Override
    protected double descuento() {
        return (this.sueldoBasico() * COEF_DESC_BASICO) + (this.sueldoAdicional() * COEF_DESC_ADICIONAL);
    }
}
