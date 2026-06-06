package parcialPaquetes;

public class SeguroDecorador extends PaqueteDecorador{

    public SeguroDecorador(Componente componente) {
        super(componente);
    }

    @Override
    public double getCostoEnvio(){
        return this.componente.getCostoEnvio() + (this.componente.getValorDeclarado() * 0.2);
    }

    @Override
    public String getDescripcion() {
        return this.componente.getDescripcion() + " - con seguro";
    }
}