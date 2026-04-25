package ejercicio06;

import java.util.ArrayList;
import java.util.List;

public abstract class Builder {
    protected List<Ingrediente> ingredientes;

    public void reiniciar(){
        this.ingredientes = new ArrayList<>();
    }

    public abstract void agregarPan();
    public abstract void agregarAderezo();
    public abstract void agregarPrincipal();
    public abstract void agregarAdicional();

    public Sanguche armar(){
        return new Sanguche(this.ingredientes);
    }
}
