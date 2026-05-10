package ejercicio10;

public class EsperandoValor extends Estado{
    private Operacion op;

    public EsperandoValor(Operacion op){
        this.op = op;
    }

    @Override
    public Estado setValor(double x, Calculadora c) {
        try{
            c.setAcumulado(op.aplicarOperacion(c.getAcumulado(), x));
            return new EsperandoOperacion();
        }
        catch(Exception e){
            return new Error();
        }
    }

    @Override
    public Estado operacionPendiente(Operacion op, Calculadora c) {
        return new Error();
    }
}
