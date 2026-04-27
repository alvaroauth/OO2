package ejercicio08;

import java.time.LocalDate;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
    private String nombre;
    private Estado estado;
    private LocalDateTime inicio;
    private LocalDateTime fin;
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

    public void addComment(String comentario){
        if (this.estado.permiteComentarios())
            this.comentarios.add(comentario);
    }

    void registrarInicio(){
        this.inicio = LocalDateTime.now();
    }

    void registrarFin(){
        this.fin = LocalDateTime.now();
    }

    LocalDateTime getInicio() {
        return inicio;
    }

    LocalDateTime getFin() {
        return fin;
    }
}
