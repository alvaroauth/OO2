package ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Archivo implements Elemento{
    private String nombre;
    private int tamanio;
    private LocalDate fechaCreacion;

    public Archivo(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.fechaCreacion = LocalDate.now();
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    @Override
    public Archivo archivoMasGrande() {
        return this;
    }

    @Override
    public Archivo archivoMasNuevo() {
        return this;
    }

    @Override
    public Elemento buscar(String nombre) {
        if (nombre.equals(this.nombre)) {
            return this;
        }
        return null;
    }

    @Override
    public List<Elemento> buscarTodos(String nombre) {
        if (nombre.equals(this.nombre)) {
            return new List.of(this);
        }
    }

    @Override
    public void listar(String pathPadre, StringBuilder salida) {
        salida.append(pathPadre);
    }

    @Override
    public Elemento add(Elemento e) {
        return new Directorio(this.nombreSinExtension(), List.of(this, e));
    }

    @Override
    public Elemento remove(Elemento e) {
        return new Archivo("Vacio", 0); //Aca puedo meter un null object
    }

    private String nombreSinExtension(){
        String[] aux = this.getNombre().split("\\.");
        return aux[0];
    }
}
