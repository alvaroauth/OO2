package parcialPaquetes;

public class SeguimientoDecorador extends PaqueteDecorador{
    private static final double AUMENTO = 2000.0;
    public SeguimientoDecorador(Componente componente){
        super(componente);
    }

    @Override
    public double getCostoEnvio(){
        return this.componente.getCostoEnvio() + AUMENTO;
    }
}
