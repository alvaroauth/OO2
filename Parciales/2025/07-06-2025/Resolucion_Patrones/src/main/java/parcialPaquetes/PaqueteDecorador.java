package parcialPaquetes;

public abstract class PaqueteDecorador implements Componente{
    protected Componente componente;

    public PaqueteDecorador(Componente componente){
        this.componente = componente;
    }

    @Override
    public String getDescripcion() {
        return this.componente.getDescripcion();
    }

    @Override
    public String getDestinatario() {
        return this.componente.getDestinatario();
    }

    @Override
    public String getDireccionDestino() {
        return this.componente.getDireccionDestino();
    }

    @Override
    public double getValorDeclarado() {
        return this.componente.getValorDeclarado();
    }

    @Override
    public double getCostoEnvio() {
        return this.componente.getCostoEnvio();
    }
}
