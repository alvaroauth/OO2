package parcialPlanes;

import java.time.LocalDate;

public class Afiliado {
    private String nombre;
    private int familiaresACargo;
    private double salario;
    private LocalDate fechaNacimiento;
    private PlanMedico plan;
    private ICoseguro coseguro;

    public Afiliado(String nombre, int familiaresACargo, double salario, LocalDate fechaNacimiento, PlanMedico plan, ICoseguro coseguro) {
        this.nombre = nombre;
        this.familiaresACargo = familiaresACargo;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.plan = plan;
        this.coseguro = coseguro;
    }

    public double calcularMonto(){
        this.planMedico.calcularMonto();
    }

    public void setPlanMedico(PlanMedico plan) {
        this.plan = plan;
    }
}
