package ejercicio18.Armas;

public class Baston implements Arma{

    @Override
    public int pelearContraCuero() {
        return 2;
    }

    @Override
    public int pelearContraHierro() {
        return 1;
    }

    @Override
    public int pelearContraAcero() {
        return 1;
    }
}
