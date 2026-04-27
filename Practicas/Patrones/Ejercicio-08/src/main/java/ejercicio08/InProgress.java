package ejercicio08;

import java.time.Duration;
import java.time.LocalDate;

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
        return Duration.between(tdi.getInicio(), LocalDate.now());
    }

    @Override
    public boolean permiteComentarios(){
        return true;
    }
}
