package ejercicio04;

public class Tierra implements Elemento {

    @Override
    public double getProporcionAgua() {
        return 0;
    }

    @Override
    public double getProporcionTierra() {
        return 1;
    }

    @Override
    public boolean comparar(Elemento otro) {
        return otro.comparar(this);
    }

    @Override
    public boolean comparar(Mixta m) {
        return this.getProporcionTierra() == m.getProporcionTierra();
    }

    @Override
    public boolean comparar(Agua a){
        return false;
    }

    @Override
    public boolean comparar(Tierra t){
        return true;
    }
}
