package ejercicio08;

import java.time.Duration;

public class Finished extends Estado{

    @Override
    public Duration workedTime(ToDoItem tdi) {
        return Duration.between(tdi.getInicio(), tdi.getFin());
    }

    @Override
    public boolean permiteComentarios(){
        return false;
    }
}