package ar.edu.unlp.info.oo1.Ejercicio06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTemporarioTest {

    @Test
    void getSueldoBasicoReturnsCorrecto() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 0, 0);
        assertEquals(50000, e.getSueldoBasico());
    }

    @Test
    void sueldoEspecificoSoloHoras() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 10, 0);
        assertEquals(5000, e.sueldoEspecifico());
    }

    @Test
    void sueldoEspecificoSoloHijos() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 0, 3);
        assertEquals(3000, e.sueldoEspecifico());
    }

    @Test
    void sueldoEspecificoConHorasYHijos() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 10, 2);
        assertEquals(7000, e.sueldoEspecifico());
    }

    @Test
    void sueldoEspecificoCeroSinHorasNiHijos() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 0, 0);
        assertEquals(0, e.sueldoEspecifico());
    }

    @Test
    void sueldoEsIgualASueldoEspecificoConIVACero() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 10, 2);
        assertEquals(e.sueldoEspecifico(), e.sueldo());
    }

    @Test
    void sueldoNoDependeDelSueldoBasico() {
        EmpleadoTemporario e1 = new EmpleadoTemporario("Ana", "Lopez", 10000, 10, 2);
        EmpleadoTemporario e2 = new EmpleadoTemporario("Ana", "Lopez", 99999, 10, 2);
        assertEquals(e1.sueldo(), e2.sueldo());
    }

    @Test
    void sueldoConHorasDecimales() {
        EmpleadoTemporario e = new EmpleadoTemporario("Ana", "Lopez", 50000, 1.5, 0);
        assertEquals(750.0, e.sueldoEspecifico(), 0.001);
    }
}