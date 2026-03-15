package ejercicio2;

public class Lagarto implements Eleccion{

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
        return "Gana lagarto";
    }

    @Override
    public String contraTijera() {
        return "Gana Tijera";
    }

    @Override
    public String contraLagarto() {
        return "Empate";
    }

    @Override
    public String contraSpock() {
        return "Gana lagarto";
    }
}
