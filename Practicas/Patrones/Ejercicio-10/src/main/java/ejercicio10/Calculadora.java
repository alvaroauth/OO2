package ejercicio10;

public class Calculadora {
    private double acumulado = 0;
    private Estado estado = new EsperandoOperacion();

    public String getResultado() {
        return this.estado.getResultado(this);
    }

    public void setValor(double x) {
        this.estado = this.estado.setValor(x, this);
    }

    public void borrar(){
        this.acumulado = 0;
        this.estado = new EsperandoOperacion();
    }

    public void mas(){
        this.estado = this.estado.operacionPendiente(new Mas(), this);
    }

    public void menos(){
        this.estado = this.estado.operacionPendiente(new Menos(), this);
    }

    public void por(){
        this.estado = this.estado.operacionPendiente(new Por(), this);
    }

    public void dividido(){
        this.estado = this.estado.operacionPendiente(new Dividido(), this);
    }

    double getAcumulado() {
        return acumulado;
    }

    void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }
}
