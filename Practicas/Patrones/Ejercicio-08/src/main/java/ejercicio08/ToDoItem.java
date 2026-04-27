package ejercicio08;

import java.time.LocalDate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
    private String nombre;
    private Estado estado;
    private LocalDate inicio;
    private LocalDate fin;
    private List<String> comentarios;

    public ToDoItem(String name){
        this.nombre = name;
        estado = new Pending();
        comentarios = new ArrayList<>();
    }

    public void start(){
        this.estado = estado.start(this);
    }

    public void togglePause(){
        this.estado = estado.togglePause();
    }

    public void finish(){
        this.estado = estado.finish(this);
    }

    public Duration workedTime(){
        return estado.workedTime(this);
    }

    public void registrarInicio(){
        this.inicio = LocalDate.now();
    }

    public void addCOmentario(String comentario){
        if (this.estado.permiteComentarios())
            this.comentarios.add(comentario);
    }

    public void registrarFin(){
        this.fin = LocalDate.now();
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }
}
