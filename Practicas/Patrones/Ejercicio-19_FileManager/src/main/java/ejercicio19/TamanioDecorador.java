package ejercicio19;

public class TamanioDecorador extends VistaDecorador{
    public TamanioDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        return Long.toString(this.getArchivo().getTamanio());
    }
}
