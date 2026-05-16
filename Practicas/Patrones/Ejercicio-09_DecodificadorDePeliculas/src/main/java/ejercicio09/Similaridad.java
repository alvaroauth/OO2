package ejercicio09;

import java.util.Comparator;
import java.util.List;

public class Similaridad extends Estrategia{
    @Override
    protected Comparator<Pelicula> comparadorPeliculas() {
        return Comparator.comparingInt((Pelicula p) -> p.getEstreno()).reversed();
    }

    @Override
    protected List<Pelicula> listaUsada(Decodificador d) {
        return d.calcularSimilaresNoVistas();
    }
}
