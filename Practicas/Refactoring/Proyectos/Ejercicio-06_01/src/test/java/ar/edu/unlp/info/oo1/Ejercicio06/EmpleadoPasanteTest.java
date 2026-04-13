package ar.edu.unlp.info.oo1.Ejercicio06;
 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 
class EmpleadoPasanteTest {
 
    private static final double DELTA = 0.001;
 
    private EmpleadoPasante crear(double sueldoBasico) {
        return new EmpleadoPasante("Juan", "Pérez", sueldoBasico);
    }
 
    @Test
    void getSueldoBasico_cero() {
        assertEquals(0.0, crear(0.0).getSueldoBasico(), DELTA);
    }
 
    @Test
    void getSueldoBasico_positivo() {
        assertEquals(50_000.0, crear(50_000.0).getSueldoBasico(), DELTA);
    }
 
    @Test
    void getSueldoBasico_negativo() {
        assertEquals(-1.0, crear(-1.0).getSueldoBasico(), DELTA);
    }
 
    @Test
    void getSueldoBasico_maximo() {
        assertEquals(Double.MAX_VALUE, crear(Double.MAX_VALUE).getSueldoBasico(), DELTA);
    }
 
    @Test
    void sueldoEspecifico_siempreCero() {
        assertEquals(0.0, crear(50_000.0).sueldoEspecifico(), DELTA);
    }
 
    @Test
    void sueldoEspecifico_conSueldoBasicoCero() {
        assertEquals(0.0, crear(0.0).sueldoEspecifico(), DELTA);
    }
 
    @Test
    void sueldoEspecifico_conSueldoBasicoNegativo() {
        assertEquals(0.0, crear(-999.0).sueldoEspecifico(), DELTA);
    }
 
    @Test
    void sueldo_sueldoBasicoCero() {
        assertEquals(0.0, crear(0.0).sueldo(), DELTA);
    }
 
    @Test
    void sueldo_sueldoBasicoPositivo() {
        assertEquals(0.0, crear(50_000.0).sueldo(), DELTA);
    }
 
    @Test
    void sueldo_sueldoBasicoNegativo() {
        assertEquals(0.0, crear(-1.0).sueldo(), DELTA);
    }
 
    @Test
    void sueldo_sueldoBasicoMaximo() {
        assertEquals(0.0, crear(Double.MAX_VALUE).sueldo(), DELTA);
    }
}