package ejercicio11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Directorio implements Elemento{
    private static final double PESO_DIRECTORIO = 32;

    private String nombre;
    private LocalDate fechaCreacion;
    private List<Elemento>  elementos;

    public Directorio(String nombre) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.elementos = new ArrayList<>();
    }

    public Directorio(String nombre, List<Elemento> elementos) {
        this.nombre = nombre;
        this.fechaCreacion = LocalDate.now();
        this.elementos = elementos;
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
        return elementos.stream().max(e -> e.get);
    }

    @Override
    public Archivo archivoMasNuevo() {
        return null;
    }

    @Override
    public Elemento buscar(String nombre) {
        return ;
    }

    @Override
    public List<Elemento> buscarTodos(String nombre) {
        return List.of();
    }

    @Override
    public void listar(String pathPadre, StringBuilder salida) {

    }

    @Override
    public Elemento add(Elemento e) {
        this.elementos.add(e);
        return this;
    }

    @Override
    public Elemento remove(Elemento e) {
        return null;
    }


}
