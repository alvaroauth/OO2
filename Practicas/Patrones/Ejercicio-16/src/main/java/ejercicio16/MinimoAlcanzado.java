package ejercicio16;

import java.util.stream.Collectors;

public class MinimoAlcanzado implements EstadoExcursion{
    @Override
    public String informacionEspecifica(Excursion e) {
        String aux = "Cantidad de usuarios faltantes: " + (e.getCupoMaximo() - e.getCupoActual()) + "\n";
        aux += " -*-*-*- LISTA DE USUARIOS INSCRIPTOS -*-*-*-\n";
        aux += e.getInscriptos().stream().map(Usuario::getEmail).collect(Collectors.joining("\n"));
        return aux;
    }

    @Override
    public EstadoExcursion agregarInscripto(Excursion e, Usuario u) {
        e.inscribirNormal(u);
        if (e.getCupoActual() == e.getCupoMaximo()){
            return new Lleno();
        }
        return this;
    }
}
