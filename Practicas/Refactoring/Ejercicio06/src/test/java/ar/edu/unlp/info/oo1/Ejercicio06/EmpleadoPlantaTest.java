package ar.edu.unlp.info.oo1.Ejercicio06;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoPlantaTest {


    private static final double PLATA_POR_HIJO = 2000.0;
    private static final double DELTA = 0.001; // tolerancia para doubles

    private EmpleadoPlanta crear(double sueldoBasico, int hijos) {
        return new EmpleadoPlanta("Juan", "Pérez", sueldoBasico, hijos);
    }

    @Test
    void getSueldoBasico_cero() {
        EmpleadoPlanta e = crear(0.0, 0);
        assertEquals(0.0, e.getSueldoBasico(), DELTA);
    }

    @Test
    void getSueldoBasico_positivo() {
        EmpleadoPlanta e = crear(50_000.0, 0);
        assertEquals(50_000.0, e.getSueldoBasico(), DELTA);
    }

    @Test
    void getSueldoBasico_negativo() {
        EmpleadoPlanta e = crear(-1.0, 0);
        assertEquals(-1.0, e.getSueldoBasico(), DELTA);
    }

    @Test
    void getSueldoBasico_maximoDouble() {
        EmpleadoPlanta e = crear(Double.MAX_VALUE, 0);
        assertEquals(Double.MAX_VALUE, e.getSueldoBasico(), DELTA);
    }

    @Test
    void sueldoEspecifico_sinHijos() {
        EmpleadoPlanta e = crear(50_000.0, 0);
        assertEquals(0.0, e.sueldoEspecifico(), DELTA);
    }

    @Test
    void sueldoEspecifico_unHijo() {
        EmpleadoPlanta e = crear(50_000.0, 1);
        assertEquals(PLATA_POR_HIJO, e.sueldoEspecifico(), DELTA);
    }

    @Test
    void sueldoEspecifico_dosHijos() {
        EmpleadoPlanta e = crear(50_000.0, 2);
        assertEquals(2 * PLATA_POR_HIJO, e.sueldoEspecifico(), DELTA);
    }

    @Test
    void sueldoEspecifico_muchosHijos() {
        int hijos = 100;
        EmpleadoPlanta e = crear(50_000.0, hijos);
        assertEquals(hijos * PLATA_POR_HIJO, e.sueldoEspecifico(), DELTA);
    }

    @Test
    void sueldoEspecifico_hijosNegativos() {
        EmpleadoPlanta e = crear(50_000.0, -1);
        assertEquals(-PLATA_POR_HIJO, e.sueldoEspecifico(), DELTA);
    }

    @Test
    void sueldo_sinHijos_sueldoBasicoCero() {
        // 0 + 0 - (0 - 0) = 0
        EmpleadoPlanta e = crear(0.0, 0);
        assertEquals(0.0, e.sueldo(), DELTA);
    }

    @Test
    void sueldo_sinHijos_conSueldoBasico() {
        EmpleadoPlanta e = crear(50_000.0, 0);
        assertEquals(0.0, e.sueldo(), DELTA);
    }

    @Test
    void sueldo_unHijo_conSueldoBasico() {
        EmpleadoPlanta e = crear(50_000.0, 1);
        assertEquals(PLATA_POR_HIJO, e.sueldo(), DELTA);
    }

    @Test
    void sueldo_dosHijos_conSueldoBasico() {
        EmpleadoPlanta e = crear(50_000.0, 2);
        assertEquals(2 * PLATA_POR_HIJO, e.sueldo(), DELTA);
    }

    @Test
    void sueldo_sinHijos_sueldoBasicoNegativo() {
        EmpleadoPlanta e = crear(-10_000.0, 0);
        assertEquals(0.0, e.sueldo(), DELTA);
    }

    @Test
    void sueldo_unHijo_sueldoBasicoCero() {
        EmpleadoPlanta e = crear(0.0, 1);
        assertEquals(PLATA_POR_HIJO, e.sueldo(), DELTA);
    }
}