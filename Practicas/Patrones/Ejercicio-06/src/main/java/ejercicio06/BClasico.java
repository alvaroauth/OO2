package ejercicio06;

public class BClasico extends Builder{
    @Override
    public void agregarPan() {
        this.ingredientes.add(new Ingrediente("Brioche", 100.0));
    }

    @Override
    public void agregarAderezo() {
        this.ingredientes.add(new Ingrediente("Mayonesa", 20.0));
    }

    @Override
    public void agregarPrincipal() {
        this.ingredientes.add(new Ingrediente("Carne de Ternera", 300.0));
    }

    @Override
    public void agregarAdicional() {
        this.ingredientes.add(new Ingrediente("Tomate", 80.0));
    }
}
