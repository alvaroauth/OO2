package ejercicio04;

import java.util.List;

public class Mixta implements Elemento{
    private List<Elemento> elementos;

    public Mixta(List<Elemento> elementos) {
        if (elementos != null &&  elementos.size() == 4)
            this.elementos = elementos;
        else
            throw new IllegalArgumentException("Se deben ingresar arreglos de 4 elementos");
    }

    @Override
    public double getProporcionAgua() {
        return elementos.stream().mapToDouble(e -> e.getProporcionAgua()).sum() / 4;
    }

    @Override
    public double getProporcionTierra() {
        return elementos.stream().mapToDouble(e -> e.getProporcionTierra()).sum() / 4;
    }

    public boolean comparar (Elemento otro) {
        return otro.comparar(this);
    }

    public boolean comparar (Mixta m){
        return m.elementos.equals(this.elementos);
    }

    @Override
    public boolean comparar(Agua a) {
        return a.getProporcionAgua() == this.getProporcionAgua();
    }

    @Override
    public boolean comparar(Tierra t) {
        return t.getProporcionTierra() == this.getProporcionTierra();
    }
}
