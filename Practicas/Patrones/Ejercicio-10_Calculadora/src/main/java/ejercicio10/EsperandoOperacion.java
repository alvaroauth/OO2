package ejercicio10;

public class EsperandoOperacion extends Estado{

    @Override
    public Estado setValor(double x, Calculadora c){
        c.setAcumulado(x);
        return this;
    }

    @Override
    public Estado operacionPendiente(Operacion op, Calculadora c){
        return new EsperandoValor(op);
    }
}
