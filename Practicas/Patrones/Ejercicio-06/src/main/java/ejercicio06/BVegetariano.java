package ejercicio06;

public class BVegetariano extends Builder{
    @Override
    public void agregarPan() {
        this.ingredientes.add(new Ingrediente("Semillas", 120.0));
    }

    @Override
    public void agregarAderezo() {}

    @Override
    public void agregarPrincipal() {
        this.ingredientes.add(new Ingrediente("Provoleta Grillada", 200.0));
    }

    @Override
    public void agregarAdicional() {
        this.ingredientes.add(new Ingrediente("Berenjenas al Escabeche", 100.0));
    }


}
