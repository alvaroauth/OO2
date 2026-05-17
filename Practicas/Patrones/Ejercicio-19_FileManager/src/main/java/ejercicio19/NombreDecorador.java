package ejercicio19;

public class NombreDecorador extends VistaDecorador{

    public NombreDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        return this.getArchivo().getNombre();
    }
}
