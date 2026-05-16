package ejercicio07;

import java.time.LocalDate;

public abstract class Producto {
    private LocalDate fechaOperacion;

    public Producto() {
        this.fechaOperacion = LocalDate.now();
    }

    public abstract double retornoInversion(double montoInicial);
}