package ejercicio11;

import java.time.LocalDate;
import java.util.List;

public interface Elemento {
    String getNombre();
    LocalDate getFechaCreacion();
    Archivo archivoMasGrande();
    Archivo archivoMasNuevo();
    Elemento buscar(String nombre);
    List<Elemento> buscarTodos(String nombre);
    void listar(String pathPadre, StringBuilder salida);
    Elemento add(Elemento e);
    Elemento remove(Elemento e);

}
