package ejercicio06;

public class Main {
    public static void main(String[] args) {
        Director d = new Director();

        BClasico bc =  new BClasico();
        BVegetariano bvt =  new BVegetariano();
        BVegano bvg =  new BVegano();
        BSinTACC bst =  new BSinTACC();

        d.construir(bc);
        d.construir(bst);
        d.construir(bvt);
        d.construir(bvg);

        Sanguche clasico = bc.armar();
        Sanguche vegetariano = bvt.armar();
        Sanguche vegano = bvg.armar();
        Sanguche sinTacc = bst.armar();

        System.out.println("=== Precios de los sanguches ===");
        System.out.println("Clásico:     $" + clasico.getPrecio());
        System.out.println("Vegetariano: $" + vegetariano.getPrecio());
        System.out.println("Vegano:      $" + vegano.getPrecio());
        System.out.println("Sin TACC:    $" + sinTacc.getPrecio());
    }
}
