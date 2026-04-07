package ejercicio03;

public abstract class Ring {
    private int idx = 0;

    protected void setearIndiceEn0(){
        this.idx = 0;
    }

    protected int siguienteYAvanzar(){
        if (idx >= this.tamanio())
            setearIndiceEn0();
        return idx++;
    }

    protected abstract int tamanio();
}
