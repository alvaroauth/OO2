package ejercicio19;

import java.time.LocalDate;

public abstract class Decorador implements ComponenteArchivo {
    protected ComponenteArchivo componente;

    public Decorador(ComponenteArchivo c) {
        this.componente = c;
    }

    @Override
    public String getNombre() {
        return this.componente.getNombre();
    }

    @Override
    public String getExtension() {
        return this.componente.getExtension();
    }

    @Override
    public int getTamanio() {
        return this.componente.getTamanio();
    }

    @Override
    public LocalDate getCreacion() {
        return this.componente.getCreacion();
    }

    @Override
    public LocalDate getModificacion() {
        return this.componente.getModificacion();
    }

    @Override
    public String getPermisos() {
        return this.componente.getPermisos();
    }
}
