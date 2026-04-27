package ejercicio08;

import java.time.Duration;

public class Pending extends Estado{

    @Override
    public Estado start(ToDoItem tdi) {
        tdi.registrarInicio();
        return new InProgress();
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
