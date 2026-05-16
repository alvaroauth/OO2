package ejercicio08;

import java.time.Duration;

public abstract class Estado {
    public Estado start(ToDoItem tdi) { return this;}

    public Estado finish(ToDoItem tdi) { return this;}

    public Estado togglePause() {
        throw new RuntimeException("El item debe estar en \"En Progreso\" o en \"Paused\" para ejecutar esto");
    }

    public abstract Duration workedTime(ToDoItem tdi);

    public abstract boolean permiteComentarios();
}