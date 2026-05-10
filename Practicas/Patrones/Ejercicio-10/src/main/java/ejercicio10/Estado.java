package ejercicio10;

public abstract class Estado {

    public String getResultado(Calculadora c){
        return String.valueOf(c.getAcumulado());
    }

    public abstract Estado setValor(double x, Calculadora c);
    public abstract Estado operacionPendiente(Operacion op, Calculadora c);
}
