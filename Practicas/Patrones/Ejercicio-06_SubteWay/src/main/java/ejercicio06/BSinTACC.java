package ejercicio06;

public class BSinTACC extends Builder{
    @Override
    public void agregarPan() {
        this.ingredientes.add(new Ingrediente("Chipa", 150.0));
    }

    @Override
    public void agregarAderezo() {
        this.ingredientes.add(new Ingrediente("Salsa Tartara", 18.0));
    }

    @Override
    public void agregarPrincipal() {
        this.ingredientes.add(new Ingrediente("Carne de Pollo", 250.0));
    }

    @Override
    public void agregarAdicional() {
        this.ingredientes.add(new Ingrediente("Verduras Grilladas", 200.0));
    }
}
