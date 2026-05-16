package ejercicio06;

public class Director {
    public void construir(Builder b){
        b.reiniciar();
        b.agregarPan();
        b.agregarAderezo();
        b.agregarPrincipal();
        b.agregarAdicional();
    }
}
