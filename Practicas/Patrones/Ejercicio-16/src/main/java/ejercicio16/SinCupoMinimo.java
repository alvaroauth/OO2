package ejercicio16;

public class SinCupoMinimo implements EstadoExcursion{
    @Override
    public String informacionEspecifica(Excursion e) {
        return "Cantidad de usuarios faltantes: " + (e.getCupoMinimo() - e.getCupoActual());
    }

    @Override
    public EstadoExcursion agregarInscripto(Excursion e, Usuario u) {
        e.inscribirNormal(u);
        if (e.getCupoActual() == e.getCupoMinimo()){
            return new MinimoAlcanzado();
        }
        return this;
    }
}
