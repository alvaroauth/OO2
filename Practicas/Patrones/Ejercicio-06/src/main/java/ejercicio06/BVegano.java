package ejercicio06;

public class BVegano extends Builder{
    @Override
    public void agregarPan() {
        this.ingredientes.add(new Ingrediente("Integral", 100.0));
    }

    @Override
    public void agregarAderezo() {
        this.ingredientes.add(new Ingrediente("Salsa Criolla", 20.0));
    }

    @Override
    public void agregarPrincipal() {
        this.ingredientes.add(new Ingrediente("Milanesa de Girgolas", 500.0));
    }

    @Override
    public void agregarAdicional() {}
}
