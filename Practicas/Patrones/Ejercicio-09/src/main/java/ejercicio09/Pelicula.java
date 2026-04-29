package ejercicio09;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String titulo;
    private int estreno;
    private double puntaje;
    private List<Pelicula> similares;

    public Pelicula(String titulo, int estreno, double puntaje) {
        this.titulo = titulo;
        this.estreno = estreno;
        this.puntaje = puntaje;
        similares = new ArrayList<>();
    }

    public void agregarSimilar(Pelicula pelicula) {
        similares.add(pelicula);
        pelicula.agregarSinRestriccion(this);
    }

    public void agregarSinRestriccion(Pelicula pelicula) {
        similares.add(pelicula);
    }

    public double getPuntaje() {
        return puntaje;
    }

    public int getEstreno() {
        return estreno;
    }

    public List<Pelicula> getSimilares() {
        return similares;
    }
}
