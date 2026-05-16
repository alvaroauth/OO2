package ejercicio08;

import org.junit.jupiter.api.Test;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoItemTest {

    // ========== Construcción / estado inicial ==========

    @Test
    void unToDoItemRecienCreadoEstaEnPending_yWorkedTimeTiraError() {
        ToDoItem t = new ToDoItem("Estudiar");
        RuntimeException e = assertThrows(RuntimeException.class, t::workedTime);
        assertEquals("Tarea no iniciada", e.getMessage());
    }

    // ========== start ==========

    @Test
    void startDesdePendingPasaAInProgressYRegistraInicio() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        Thread.sleep(20);
        Duration d = t.workedTime();   // si no explota, está en in-progress
        assertTrue(d.toMillis() >= 20);
    }

    @Test
    void startDesdeInProgressNoHaceNada() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        Thread.sleep(50);
        Duration antes = t.workedTime();

        t.start();   // no debería resetear el inicio
        Duration despues = t.workedTime();

        assertTrue(despues.compareTo(antes) >= 0,
                "El segundo start no debe reiniciar el cronómetro");
    }

    @Test
    void startDesdeFinishedNoHaceNada() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.finish();
        Duration antes = t.workedTime();

        t.start();   // no debería volver a in-progress
        Duration despues = t.workedTime();

        assertEquals(antes, despues,
                "Una tarea finalizada no debe poder reiniciarse");
    }

    @Test
    void startDesdePausedNoHaceNada() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();
        Thread.sleep(20);

        // start no debería sacarla de pausa
        t.start();
        // togglePause debería todavía pasarla a in-progress
        t.togglePause();
        assertTrue(t.workedTime().toMillis() >= 20);
    }

    // ========== togglePause ==========

    @Test
    void togglePauseDesdePendingTiraError() {
        ToDoItem t = new ToDoItem("Estudiar");
        RuntimeException e = assertThrows(RuntimeException.class, t::togglePause);
        assertTrue(e.getMessage().contains("En Progreso") ||
                e.getMessage().contains("Paused") ||
                e.getMessage().contains("in-progress") ||
                e.getMessage().contains("pause"));
    }

    @Test
    void togglePauseDesdeInProgressPasaAPaused() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();   // ahora en paused
        Thread.sleep(20);

        // workedTime debe seguir funcionando en paused
        assertTrue(t.workedTime().toMillis() >= 20);
    }

    @Test
    void togglePauseDesdePausedVuelveAInProgress() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();   // paused
        t.togglePause();   // in-progress

        // finish debería funcionar (sólo funciona en in-progress o paused)
        assertDoesNotThrow(t::finish);
    }

    @Test
    void togglePauseDesdeFinishedTiraError() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.finish();
        assertThrows(RuntimeException.class, t::togglePause);
    }

    // ========== finish ==========

    @Test
    void finishDesdePendingNoHaceNada() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.finish();   // no debería pasar a finished

        // si está en pending, workedTime tira error
        assertThrows(RuntimeException.class, t::workedTime);
    }

    @Test
    void finishDesdeInProgressPasaAFinished() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.finish();

        // En finished, workedTime no tira error y devuelve un valor estable
        Duration d1 = t.workedTime();
        Duration d2 = t.workedTime();
        assertEquals(d1, d2,
                "En finished el tiempo trabajado debe ser fijo");
    }

    @Test
    void finishDesdePausedPasaAFinished() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();
        t.finish();

        Duration d1 = t.workedTime();
        Duration d2 = t.workedTime();
        assertEquals(d1, d2);
    }

    @Test
    void finishDesdeFinishedNoHaceNada() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.finish();
        Duration primeraVez = t.workedTime();

        Thread.sleep(20);
        t.finish();   // no debería actualizar el fin
        Duration segundaVez = t.workedTime();

        assertEquals(primeraVez, segundaVez,
                "Un segundo finish no debe modificar el tiempo trabajado");
    }

    // ========== workedTime ==========

    @Test
    void workedTimeEnInProgressCreceConElTiempo() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        Thread.sleep(30);
        Duration d1 = t.workedTime();
        Thread.sleep(30);
        Duration d2 = t.workedTime();

        assertTrue(d2.compareTo(d1) > 0,
                "En in-progress el tiempo debe seguir corriendo");
    }

    @Test
    void workedTimeEnFinishedEsConstante() throws InterruptedException {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        Thread.sleep(20);
        t.finish();

        Duration d1 = t.workedTime();
        Thread.sleep(30);
        Duration d2 = t.workedTime();

        assertEquals(d1, d2,
                "En finished el tiempo trabajado no debe cambiar");
    }

    @Test
    void workedTimeEnPausedSigueCorriendo() throws InterruptedException {
        // Nota: según el enunciado, workedTime mide desde start hasta ahora
        // (o hasta el fin si está finished). En paused sigue contando.
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();
        Thread.sleep(30);
        Duration d = t.workedTime();
        assertTrue(d.toMillis() >= 30);
    }



    // ========== Flujos completos ==========

    @Test
    void cicloCompletoStartFinish() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.finish();
        assertDoesNotThrow(t::workedTime);
    }

    @Test
    void cicloConPausasMultiples() {
        ToDoItem t = new ToDoItem("Estudiar");
        t.start();
        t.togglePause();
        t.togglePause();
        t.togglePause();
        t.togglePause();
        t.finish();
        assertDoesNotThrow(t::workedTime);
    }
}