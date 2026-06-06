package parcialPaquetes;

public class EntregaExpresDecorador extends PaqueteDecorador{

    public EntregaExpresDecorador(Componente componente) {
        super(componente);
    }

    @Override
    public double getCostoEnvio(){
        return this.componente.getCostoEnvio() + ( this.componente.getValorDeclarado() * 0.5);
    }

    @Override
    public String getDescripcion(){
        return this.componente.getDescripcion() + " - envio express";
    }
}
