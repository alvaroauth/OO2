package ejercicio19;

public abstract class VistaDecorador implements VistaArchivo {
    private FileOO2 archivo;
    private VistaArchivo wrapped;

    protected VistaDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        this.archivo = archivo;
        this.wrapped = wrapped;
    }

    protected FileOO2 getArchivo(){
        return archivo;
    }

    protected VistaArchivo getWrapped(){
        return wrapped;
    }

    @Override
    public String prettyPrint() {
        String info = wrapped.prettyPrint();
        return info.isEmpty() ? aspect() : aspect() + " - " + info;
    }

    protected abstract String aspect();
}
