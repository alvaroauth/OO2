package ejercicio03;

public class CharRing extends Ring{
    private char[] source;

    public CharRing(String src) {
        super();
        source = src.toCharArray();
    }

    public char next() {
        return source[this.siguienteYAvanzar()];
    }

    @Override
    protected int tamanio() { return source.length; }
}
