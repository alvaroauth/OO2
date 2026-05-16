package ejercicio12;

import java.time.LocalDate;

public class Reserva {
    private int cantidadDias;
    private LocalDate fecha;
    private Usuario conductor;
    private AutoEnAlquiler auto;
    private PoliticaCancelacion politica;

    public Reserva(int cd, LocalDate fecha, Usuario c, AutoEnAlquiler auto, PoliticaCancelacion p) {
        this.cantidadDias = cd;
        this.fecha = fecha;
        this.conductor = c;
        this.auto = auto;
        this.politica = p;
    }

    public double montoAPagar(){
        return cantidadDias * auto.getPrecioPorDia();
    }

    public double montoAReembolsar(){
        return politica.calcularReembolso(montoAPagar(), this.fecha);
    }

}
