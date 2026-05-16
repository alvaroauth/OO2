package ejercicio10;

public class Error extends Estado{

    @Override
    public Estado setValor(double x, Calculadora c) {
        return this;
    }

    @Override
    public Estado operacionPendiente(Operacion op, Calculadora c) {
        return this;
    }

    @Override
    public String getResultado(Calculadora c){
        return "Error";
    }
}
