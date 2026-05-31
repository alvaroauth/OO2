package ejercicio26;

import java.time.LocalDate;

public class Automovil extends Prenda{
    private static final double LIQUIDEZ = 0.7;

    private int modelo;
    private double kilometraje;
    private double costo0km;

    public Automovil(int m, double k, double c) {
        this.modelo = m;
        this.kilometraje = k;
        this.costo0km = c;
    }

    @Override
    public double getValor(){
        double aux = costo0km;
        int cant = LocalDate.now().getYear() - modelo;
        for(int i = 0; i < cant; i++){
            aux -= aux*0.10;
        }
        return aux;
    }

    @Override
    public double getLiquidez() {
        return LIQUIDEZ;
    }
}
