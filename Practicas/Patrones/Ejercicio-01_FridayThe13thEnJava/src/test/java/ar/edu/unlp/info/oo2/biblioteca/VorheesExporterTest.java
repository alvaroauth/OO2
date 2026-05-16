package ar.edu.unlp.info.oo2.biblioteca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VoorheesExporterTest {

    private VoorheesExporter exporter;

    @BeforeEach
    void setUp() {
        exporter = new VoorheesExporter();
    }

    @Test
    void exportarListaVaciaDevuelveArrayVacio() {
        assertEquals("[]", exporter.exportar(Collections.emptyList()));
    }

    @Test
    void exportarUnSocioContieneNombre() {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = exporter.exportar(List.of(socio));
        assertTrue(resultado.contains("\"nombre\": \"Juan Perez\""));
    }

    @Test
    void exportarUnSocioContieneEmail() {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = exporter.exportar(List.of(socio));
        assertTrue(resultado.contains("\"email\": \"juan@unlp.edu.ar\""));
    }

    @Test
    void exportarUnSocioContieneLegajo() {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = exporter.exportar(List.of(socio));
        assertTrue(resultado.contains("\"legajo\": \"12345\""));
    }

    @Test
    void exportarEmpiezaYTerminaConCorchetes() {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = exporter.exportar(List.of(socio)).trim();
        assertTrue(resultado.startsWith("["));
        assertTrue(resultado.endsWith("]"));
    }

    @Test
    void exportarMultiplesSociosNoTerminaConComa() {
        List<Socio> socios = List.of(
                new Socio("Ana", "ana@test.com", "1"),
                new Socio("Carlos", "carlos@test.com", "2")
        );
        String resultado = exporter.exportar(socios).trim();
        assertFalse(resultado.endsWith(",]"));
        assertTrue(resultado.endsWith("]"));
    }
}