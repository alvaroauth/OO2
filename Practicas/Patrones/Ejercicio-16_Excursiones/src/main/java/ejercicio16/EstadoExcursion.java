package ejercicio16;

public interface EstadoExcursion {
    String informacionEspecifica(Excursion e);
    EstadoExcursion agregarInscripto(Excursion e, Usuario u);
}
