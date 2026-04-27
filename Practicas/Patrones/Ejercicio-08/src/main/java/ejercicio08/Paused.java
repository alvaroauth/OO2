package ejercicio08;

import java.time.Duration;
import java.time.LocalDate;

public class Paused extends Estado{

    @Override
    public Estado togglePause() {
        return new InProgress();
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
