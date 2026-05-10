package ejercicio10;

public class Dividido implements Operacion{
    @Override
    public double aplicarOperacion(double x, double y) {
        if (y == 0) throw new ArithmeticException();
        return x / y;
    }
}
