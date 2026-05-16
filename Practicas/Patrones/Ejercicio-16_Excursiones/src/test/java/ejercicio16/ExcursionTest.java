package ejercicio16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ExcursionTest {

    private Excursion excursion;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario nuevoInscripto;

    @BeforeEach
    public void setUp() {
        excursion = new Excursion(
                "Dos días en kayak bajando el Paraná",
                15000.0,
                "Puerto de La Plata",
                1,   // cupo mínimo
                2,   // cupo máximo
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 2)
        );

        usuario1 = new Usuario("Juan", "Pérez", "juan@mail.com");
        usuario2 = new Usuario("María", "Gómez", "maria@mail.com");
        nuevoInscripto = new Usuario("Carlos", "López", "carlos@mail.com");

        // Pre-condición: dos personas ya inscriptas (cupo máximo alcanzado)
        excursion.agregarInsicrpto(usuario1);
        excursion.agregarInsicrpto(usuario2);
    }

    @Test
    public void laExcursionQuedaLlenaTrasLasDosPrimerasInscripciones() {
        assertTrue(excursion.getEstado() instanceof Lleno);
        assertEquals(2, excursion.getCupoActual());
    }

    @Test
    public void inscribirUnTercerUsuarioLoEnviaAListaEspera() {
        excursion.agregarInsicrpto(nuevoInscripto);

        assertTrue(excursion.getListaEspera().contains(nuevoInscripto));
    }

    @Test
    public void inscribirUnTercerUsuarioNoLoSumaALosInscriptosNormales() {
        excursion.agregarInsicrpto(nuevoInscripto);

        assertEquals(2, excursion.getCupoActual());
        assertFalse(excursion.getInscriptos().contains(nuevoInscripto));
    }

    @Test
    public void elEstadoSigueSiendoLlenoLuegoDeInscribirEnEspera() {
        excursion.agregarInsicrpto(nuevoInscripto);

        assertTrue(excursion.getEstado() instanceof Lleno);
    }
}