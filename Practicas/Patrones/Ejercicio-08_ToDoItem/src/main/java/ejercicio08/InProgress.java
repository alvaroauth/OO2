package ejercicio08;

import java.time.Duration;
import java.time.LocalDateTime;

public class InProgress extends Estado{

    @Override
    public Estado togglePause(){
        return new Paused();
    }

    @Override
    public Estado finish(ToDoItem tdi){
        tdi.registrarFin();
        return new Finished();
    }

    @Override
    public Duration workedTime(ToDoItem tdi) {
        return Duration.between(tdi.getInicio(), LocalDateTime.now());
    }

    @Override
    public boolean permiteComentarios(){
        return true;
    }
}
