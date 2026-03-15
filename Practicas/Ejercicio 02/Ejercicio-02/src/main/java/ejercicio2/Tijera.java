package ejercicio2;

public class Tijera implements Eleccion{

    @Override
    public String contra(Eleccion e) {
        return e.contraLagarto();
    }

    @Override
    public String contraPiedra() {
        return "Gana piedra";
    }

    @Override
    public String contraPapel() {
        return "Gana tijera";
    }

    @Override
    public String contraTijera() {
        return "Empate";
    }

    @Override
    public String contraLagarto() {
        return "Gana tijera";
    }

    @Override
    public String contraSpock() {
        return "Gana spock";
    }
}
{
}
