package parcialPaquetes;

public class FragilDecorador extends PaqueteDecorador{
    public FragilDecorador(Componente componente) {
        super(componente);
    }

    @Override
    public String getDescripcion(){
        return this.componente.getDescripcion() + " - fragil";
    }
}
