package ejercicio19;

public class PermisosDecorador extends Decorador {
    public PermisosDecorador(ComponenteArchivo componente) {
        super(componente);
    }

    @Override
    public String prettyPrint()
    {
        return this.componente.prettyPrint() + " - " + this.getPermisos();
    }
}
