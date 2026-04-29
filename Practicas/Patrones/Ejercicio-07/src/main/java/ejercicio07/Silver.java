package ejercicio07;

import java.util.ArrayList;
import java.util.List;

public class Silver extends Membresia {
    private static final double TASA_PF = 0.05;
    private static final int DIAS_MIN_PF = 35;
    private static final int PARKING_MIN_HS = 72;


    @Override
    protected int getDiasMinimo() {
        return DIAS_MIN_PF;
    }

    @Override
    protected double getInteres() {
        return TASA_PF;
    }

    @Override
    protected int getParking() {
        return PARKING_MIN_HS;
    }
}
