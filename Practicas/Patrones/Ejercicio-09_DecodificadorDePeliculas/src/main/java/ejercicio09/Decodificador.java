package ejercicio09;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
    private List<Pelicula> peliculas;
    private List<Pelicula> vistas;
    private Estrategia estrategia;

    public Decodificador(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
        this.vistas = new ArrayList<>();
    }

    public List<Pelicula> recomendarPeliculas() {
        return estrategia.recomendarPeliculas(this);
    }

    public void cambiarEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public void verPelicula(Pelicula p){
        this.vistas.add(p);
    }

    public void agregarPelicula(Pelicula p){
        this.peliculas.add(p);
    }

    public List<Pelicula> calcularNoVistas() {
        return this.peliculas.stream().filter(p -> !vistas.contains(p)).toList();
    }

    public List<Pelicula> calcularSimilaresNoVistas() {
        return vistas.stream()
                .flatMap(o -> o.getSimilares().stream())
                .distinct()
                .filter(p -> !vistas.contains(p))
                .toList();
    }
}
