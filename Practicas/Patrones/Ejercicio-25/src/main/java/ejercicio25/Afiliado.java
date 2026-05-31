package ejercicio25;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Afiliado {
    private String nombre;
    private int familiaresACargo;
    private double salario;
    private LocalDate fechaNacimiento;
    private ICoseguro coseguro;
    private PlanMedico planMedico;
    private List<PlanMedico> planesAnteriores = new ArrayList<>();

    public Afiliado(String nom, int fac, double s, LocalDate fn, ICoseguro c,  PlanMedico pm) {
        nombre = nom;
        familiaresACargo = fac;
        salario = s;
        fechaNacimiento = fn;
        coseguro = c;
        planMedico = pm;
    }

    public double calcularMonto(){
        return planMedico.getCostoMensual(this);
    }

    public void setPlanMedico(PlanMedico pm) {
        this.planesAnteriores.add(planMedico);
        planMedico = pm;
    }

    protected ICoseguro getCoseguro() {
        return coseguro;
    }

    public int getFamiliaresACargo() {
        return familiaresACargo;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
}
