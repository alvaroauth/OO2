package ejercicio19;

public class ExtensionDecorador extends Decorador {
    public ExtensionDecorador(ComponenteArchivo componente) {
        super(componente);
    }

    @Override
    public String prettyPrint(){
        return this.componente.prettyPrint() + " - " + this.getExtension();
    }
}
