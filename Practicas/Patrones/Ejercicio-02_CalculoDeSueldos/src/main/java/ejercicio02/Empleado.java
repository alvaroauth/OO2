package ejercicio02;

public abstract class Empleado {
    private String nombre;

    public  Empleado(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo(){
        return sueldoBasico() + sueldoAdicional() - descuento();
    }

    protected abstract double sueldoBasico();
    protected abstract double sueldoAdicional();
    protected abstract double descuento();
}
