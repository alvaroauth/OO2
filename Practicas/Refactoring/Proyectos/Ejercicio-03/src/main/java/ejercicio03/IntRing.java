package ejercicio03;

public class IntRing extends Ring{
    private int[] source;

    public IntRing(int[] src) {
        super();
        source = src;
    }

    public int next() {
        return source[this.siguienteYAvanzar()];
    }

    @Override
    protected int tamanio() { return source.length; }
}
