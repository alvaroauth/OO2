package ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Sanguche {
    private List<Ingrediente> ingredientes;

    public Sanguche(List<Ingrediente> ing){
        this.ingredientes = new ArrayList<>(ing);
    }

    public double getPrecio(){
        return ingredientes.stream().mapToDouble(i -> i.getPrecio()).sum();
    }
}
