package ejercicio2;

public class Papel implements Eleccion{

    @Override
    public String contra(Eleccion e) {
        return e.contraPapel();
    }

    @Override
    public String contraPiedra() {
        return "Gana papel";
    }

    @Override
    public String contraPapel() {
        return "Empate";
    }

    @Override
    public String contraTijera() {
        return "Gana Tijera";
    }

    @Override
    public String contraLagarto() {
        return "Gana lagarto";
    }

    @Override
    public String contraSpock() {
        return "Gana papel";
    }
}
{
}
