package ejercicio08;

import java.time.Duration;

public class Pending extends Estado{

    @Override
    public Estado start(ToDoItem tdi) {
        return new InProgress();
    }

    @Override
    public Estado finish(ToDoItem tdi){
        tdi.registrarFin();
        return new Finished();
    }

    @Override
    public Duration workedTime(ToDoItem tdi) {
        throw new RuntimeException("Tarea no iniciada");
    }

    @Override
    public boolean permiteComentarios() {
        return true;
    }
}
