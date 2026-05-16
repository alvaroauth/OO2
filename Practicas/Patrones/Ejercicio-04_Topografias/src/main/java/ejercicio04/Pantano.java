package ejercicio04;

public class Pantano implements Elemento{

    @Override
    public double getProporcionAgua() {
        return 0.7;
    }

    @Override
    public double getProporcionTierra() {
        return 0.3;
    }

    @Override
    public boolean equals(Elemento t) {
        return getProporcionAgua() == t.getProporcionAgua() &&  getProporcionTierra() == t.getProporcionTierra();
    }

    @Override
    public boolean esMixta(Mixta t) {
        return false;
    }
}
