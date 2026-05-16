package ejercicio18.Armas;

public class Espada implements Arma{
    @Override
    public int pelearContraCuero() {
        return 8;
    }

    @Override
    public int pelearContraHierro() {
        return 5;
    }

    @Override
    public int pelearContraAcero() {
        return 3;
    }
}
