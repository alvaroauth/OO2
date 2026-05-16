package ejercicio04;

public class Agua implements Elemento {

    @Override
    public double getProporcionAgua() {
        return 1;
    }

    @Override
    public double getProporcionTierra() {
        return 0;
    }

    @Override
    public boolean comparar(Elemento otro) {
        return otro.comparar(this);
    }

    @Override
    public boolean comparar(Mixta m) {
        return this.getProporcionAgua() == m.getProporcionAgua();
    }

    @Override
    public boolean comparar(Agua a){
        return true;
    }

    @Override
    public boolean comparar(Tierra t){
        return false;
    }
}
