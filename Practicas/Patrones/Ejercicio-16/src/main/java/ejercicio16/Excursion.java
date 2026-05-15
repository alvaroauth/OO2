package ejercicio16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String nombre;
    private double costo;
    private LocalDate inicio;
    private LocalDate fin;
    private String puntoEncuentro;

    private List<Usuario> inscriptos;
    private List<Usuario> listaEspera;
    private EstadoExcursion estado;

    private int cupoActual;
    private int cupoMinimo;
    private int cupoMaximo;

    public Excursion(String nombre, double costo, String puntoE, int cmin, int cmax, LocalDate inicio, LocalDate fin) {
        this.nombre = nombre;
        this.costo = costo;
        this.puntoEncuentro = puntoE;
        this.inicio = inicio;
        this.fin = fin;
        this.inscriptos = new ArrayList<>();
        this.listaEspera = new ArrayList<>();
        this.cupoActual = 0;
        this.cupoMinimo = cmin;
        this.cupoMaximo = cmax;
        this.estado = new SinCupoMinimo();
    }

    public void agregarInsicrpto(Usuario u){
        this.estado = estado.agregarInscripto(this, u);
    }

    protected void inscribirNormal(Usuario u){
        cupoActual++;
        this.inscriptos.add(u);
    }

    protected void inscribirListaEspera(Usuario u){
        this.listaEspera.add(u);
    }

    protected List<Usuario> getInscriptos(){
        return this.inscriptos;
    }


    public int getCupoActual() {
        return cupoActual;
    }

    public int getCupoMinimo() {
        return cupoMinimo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public EstadoExcursion getEstado(){
        return this.estado;
    }

    public List<Usuario> getListaEspera(){
        return this.listaEspera;
    }
}
