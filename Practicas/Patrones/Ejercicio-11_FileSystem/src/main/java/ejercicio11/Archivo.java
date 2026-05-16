package ejercicio11;

import java.time.LocalDate;
import java.util.List;

public class Archivo implements Elemento{
    private String nombre;
    private double tamanio;
    private LocalDate fechaCreacion;

    public Archivo(String nombre, double tamanio) {
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
        return new NullArchivo();
    }

    @Override
    public List<Elemento> buscarTodos(String nombre) {
        if (nombre.equals(this.nombre)) {
            return List.of(this);
        }
        return null;
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
        return new NullArchivo(); //Aca puedo meter un null object
    }

    private String nombreSinExtension(){
        String[] aux = this.getNombre().split("\\.");
        return aux[0];
    }

    public double getTamanio() {
        return this.tamanio;
    }
}
