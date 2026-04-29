package ejercicio09;

import java.util.Comparator;
import java.util.List;

public abstract class Estrategia {

    public List<Pelicula> recomendarPeliculas(Decodificador d){
        return listaUsada(d).stream()
                .sorted(this.comparadorPeliculas())
                .limit(3)
                .toList();
    }

    protected abstract Comparator<Pelicula> comparadorPeliculas();
    protected abstract List<Pelicula> listaUsada(Decodificador d);
}
