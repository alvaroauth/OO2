package ejercicio05;

public class Atomo implements ElementoQuimico{
    private String nombre;
    private String simbolo;
    public int pesoAtomico;
    private int carga;
    private boolean metal;

    public Atomo(String nombre, String simbolo, int pesoAtomico, int carga, boolean metal){
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.pesoAtomico = pesoAtomico;
        this.carga = carga;
        this.metal = metal;
    }

    @Override
    public String formula() {
        return simbolo;
    }

    @Override
    public int pesoMolecular() {
        return pesoAtomico;
    }

    @Override
    public int carga() {
        return carga;
    }

    @Override
    public boolean esValida() {
        return true;
    }

    @Override
    public boolean esMetal() {
        return metal;
    }
}