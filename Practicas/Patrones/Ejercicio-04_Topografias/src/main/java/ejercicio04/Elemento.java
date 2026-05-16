package ejercicio04;

public interface Elemento {
    public double getProporcionAgua();
    public double getProporcionTierra();
    public boolean comparar(Elemento otro);
    public boolean comparar(Mixta m);
    public boolean comparar(Agua a);
    public boolean comparar(Tierra t);
}
