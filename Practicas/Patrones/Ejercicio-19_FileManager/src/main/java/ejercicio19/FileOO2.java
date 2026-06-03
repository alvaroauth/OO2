package ejercicio19;

import java.time.LocalDate;

public class FileOO2 implements ComponenteArchivo {
    private String nombre;
    private String extension;
    private int tamanio;
    private LocalDate creacion;
    private LocalDate modificacion;
    private String permisos;

    public FileOO2(String nombre, String extension, int tamanio, LocalDate creacion, LocalDate modificacion, String permisos) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
        this.creacion = creacion;
        this.modificacion = modificacion;
        this.permisos = permisos;
    }

    @Override
    public String prettyPrint() {
        return this.getNombre();
    }

    public String getNombre() {
        return nombre;
    }

    public String getExtension() {
        return extension;
    }

    public int getTamanio() {
        return tamanio;
    }

    public LocalDate getCreacion() {
        return creacion;
    }

    public LocalDate getModificacion() {
        return modificacion;
    }

    public String getPermisos() {
        return permisos;
    }
}
