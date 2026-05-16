package ejercicio18.Armaduras;

import ejercicio18.Armas.Arma;

public class Acero implements Armadura{
    @Override
    public int recibirDanio(Arma a) {
        return a.pelearContraAcero();
    }
}
