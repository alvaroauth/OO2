package ejercicio26;

public abstract class  Prenda {
    public double getValorPrendario(){
        return this.getValor() * this.getLiquidez();
    }
    public abstract double getValor();
    protected abstract double getLiquidez();
}
