package ar.edu.unlp.info.oo1.Ejercicio06;

public abstract class Empleado {
	private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    
    private static final double IVA = 0;
    
	public Empleado(String nombre, String apellido, double sueldoBasico) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.sueldoBasico = sueldoBasico;
	}
	
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	public double sueldo() {
		return this.getSueldoBasico() + this.sueldoEspecifico() - (this.getSueldoBasico() - IVA);
	}
	
	protected abstract double sueldoEspecifico();
}