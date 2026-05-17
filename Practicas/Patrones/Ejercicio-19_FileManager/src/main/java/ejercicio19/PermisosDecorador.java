package ejercicio19;

public class PermisosDecorador extends VistaDecorador{
    public PermisosDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        return this.getArchivo().getPermisos();
    }
}
