package ejercicio19;

public class ExtensionDecorador extends VistaDecorador{
    public ExtensionDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        return this.getArchivo().getExtension();
    }
}
