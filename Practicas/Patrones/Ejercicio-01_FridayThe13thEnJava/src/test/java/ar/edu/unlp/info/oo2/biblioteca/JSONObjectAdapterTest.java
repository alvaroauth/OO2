package ar.edu.unlp.info.oo2.biblioteca;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONObjectAdapterTest {

    private JSONObjectAdapter adapter;
    private JSONParser parser;

    @BeforeEach
    void setUp() {
        adapter = new JSONObjectAdapter();
        parser = new JSONParser();
    }

    @Test
    void exportarListaVaciaDevuelveArrayJsonVacio() throws ParseException {
        String resultado = adapter.exportar(Collections.emptyList());
        JSONArray array = (JSONArray) parser.parse(resultado);
        assertTrue(array.isEmpty());
    }

    @Test
    void exportarListaVaciaEsJsonValido() {
        String resultado = adapter.exportar(Collections.emptyList());
        assertDoesNotThrow(() -> parser.parse(resultado));
    }

    @Test
    void exportarUnSocioDevuelveArrayConUnElemento() throws ParseException {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = adapter.exportar(List.of(socio));
        JSONArray array = (JSONArray) parser.parse(resultado);
        assertEquals(1, array.size());
    }

    @Test
    void exportarUnSocioContieneNombreCorrecto() throws ParseException {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = adapter.exportar(List.of(socio));
        JSONArray array = (JSONArray) parser.parse(resultado);
        org.json.simple.JSONObject obj = (org.json.simple.JSONObject) array.get(0);
        assertEquals("Juan Perez", obj.get("nombre"));
    }

    @Test
    void exportarUnSocioContieneEmailCorrecto() throws ParseException {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = adapter.exportar(List.of(socio));
        JSONArray array = (JSONArray) parser.parse(resultado);
        org.json.simple.JSONObject obj = (org.json.simple.JSONObject) array.get(0);
        assertEquals("juan@unlp.edu.ar", obj.get("email"));
    }

    @Test
    void exportarUnSocioContieneLegajoCorrecto() throws ParseException {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = adapter.exportar(List.of(socio));
        JSONArray array = (JSONArray) parser.parse(resultado);
        org.json.simple.JSONObject obj = (org.json.simple.JSONObject) array.get(0);
        assertEquals("12345", obj.get("legajo"));
    }

    @Test
    void exportarUnSocioSoloTieneTresCampos() throws ParseException {
        Socio socio = new Socio("Juan Perez", "juan@unlp.edu.ar", "12345");
        String resultado = adapter.exportar(List.of(socio));
        JSONArray array = (JSONArray) parser.parse(resultado);
        org.json.simple.JSONObject obj = (org.json.simple.JSONObject) array.get(0);
        assertEquals(3, obj.size());
    }

    @Test
    void exportarMultiplesSociosDevuelveCantidadCorrecta() throws ParseException {
        List<Socio> socios = List.of(
                new Socio("Ana López",   "ana@unlp.edu.ar",   "11111"),
                new Socio("Carlos Ruiz", "carlos@unlp.edu.ar","22222"),
                new Socio("María García","maria@unlp.edu.ar", "33333")
        );
        String resultado = adapter.exportar(socios);
        JSONArray array = (JSONArray) parser.parse(resultado);
        assertEquals(3, array.size());
    }

    @Test
    void exportarMultiplesSociosPreservaDatos() throws ParseException {
        Socio s1 = new Socio("Ana López",   "ana@unlp.edu.ar",   "11111");
        Socio s2 = new Socio("Carlos Ruiz", "carlos@unlp.edu.ar","22222");
        String resultado = adapter.exportar(List.of(s1, s2));
        JSONArray array = (JSONArray) parser.parse(resultado);

        org.json.simple.JSONObject obj0 = (org.json.simple.JSONObject) array.get(0);
        org.json.simple.JSONObject obj1 = (org.json.simple.JSONObject) array.get(1);

        assertEquals("Ana López",    obj0.get("nombre"));
        assertEquals("Carlos Ruiz",  obj1.get("nombre"));
    }

    @Test
    void exportarSocioConCamposVaciosNoLanzaExcepcion() {
        Socio socio = new Socio("", "", "");
        assertDoesNotThrow(() -> adapter.exportar(List.of(socio)));
    }

    @Test
    void exportarSocioConCaracteresEspecialesEsJsonValido() {
        Socio socio = new Socio("O'Brien \"Jr\"", "o'brien@test.com", "99/9");
        String resultado = adapter.exportar(List.of(socio));
        assertDoesNotThrow(() -> parser.parse(resultado));
    }
}