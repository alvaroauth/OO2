package ejercicio16;

public class Lleno implements EstadoExcursion{
    @Override
    public String informacionEspecifica(Excursion e) {
        return "";
    }

    @Override
    public EstadoExcursion agregarInscripto(Excursion e, Usuario u) {
        e.inscribirListaEspera(u);
        return this;
    }
}
