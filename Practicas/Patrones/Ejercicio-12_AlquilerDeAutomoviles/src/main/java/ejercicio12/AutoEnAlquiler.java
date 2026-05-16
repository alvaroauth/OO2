package ejercicio12;

public class AutoEnAlquiler {
    private double precioPorDia;
    private int cantidadPlazas;
    private String marca;
    private PoliticaCancelacion politica;

    public AutoEnAlquiler(double pxd, int cp, String m, PoliticaCancelacion p) {
        this.precioPorDia = pxd;
        this.cantidadPlazas = cp;
        this.marca = m;
        this.politica = p;
    }

    public void cambiarPolitica(PoliticaCancelacion p) {
        this.politica = p;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    public int getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(int cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public PoliticaCancelacion getPolitica() {
        return politica;
    }
}
