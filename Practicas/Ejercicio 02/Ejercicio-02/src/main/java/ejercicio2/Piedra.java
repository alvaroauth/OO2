package ejercicio2;

public class Piedra implements Eleccion{

    @Override
    public String contra(Eleccion e) {
        return e.contraPiedra();
    }

    @Override
    public String contraPiedra() {
        return "Empate";
    }

    @Override
    public String contraPapel() {
        return "Gana papel";
    }

    @Override
    public String contraTijera() {
        return "Gana piedra";
    }

    @Override
    public String contraLagarto() {
        return "Gana piedra";
    }

    @Override
    public String contraSpock() {
        return "Gana spock";
    }
}
{
}
