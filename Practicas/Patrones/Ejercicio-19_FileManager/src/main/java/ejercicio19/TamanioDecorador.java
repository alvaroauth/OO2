package ejercicio19;

public class TamanioDecorador extends Decorador {
    public TamanioDecorador(ComponenteArchivo componente) {
        super(componente);
    }

    @Override
    public String prettyPrint() {
        return this.componente.prettyPrint() + " - " + this.getTamanio();
    }
}
