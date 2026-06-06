package parcialPlanes;

import java.time.LocalDate;

public abstract class PlanMedico {
    private LocalDate fechaContratacion;

    public PlanMedico(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double calcularMonto(){
        return this.getMontoFijo()
                + this.getCargoFamiliar()
                + this.getCoberturaViajera()
                + this.getSeguroInternacion();


    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    protected abstract double getMontoFijo(double descuento);
    protected abstract double getCargoFamiliar(double descuento, int cantIntegrantes, double salario);
    protected abstract double getCoberturaViajera(double descuento, double salario, int antiguedad);
    protected abstract double getSeguroInternacion();
}
