package ejercicio2;

public class Spock implements Eleccion{

    @Override
    public String contra(Eleccion e) {
        return e.contraSpock();
    }

    @Override
    public String contraPiedra() {
        return "Gana spock";
    }

    @Override
    public String contraPapel() {
        return "Gana papel";
    }

    @Override
    public String contraTijera() {
        return "Gana spock";
    }

    @Override
    public String contraLagarto() {
        return "Gana lagarto";
    }

    @Override
    public String contraSpock() {
        return "Empate";
    }
}
