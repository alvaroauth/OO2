package ejercicio18.Armas;

public class Arco implements Arma{
    @Override
    public int pelearContraCuero() {
        return 5;
    }

    @Override
    public int pelearContraHierro() {
        return 3;
    }

    @Override
    public int pelearContraAcero() {
        return 2;
    }
}
