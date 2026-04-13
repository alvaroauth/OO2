package ar.edu.unlp.info.oo1.Ejercicio06;

public class EmpleadoPlanta extends Empleado{
	private static final double PLATA_POR_HIJOS = 2000;
	
	private int cantidadHijos = 0;
    
	public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantHijos) {
		super(nombre, apellido, sueldoBasico);
		this.cantidadHijos = cantHijos;
	}
	
    protected double sueldoEspecifico() {
    	return cantidadHijos * PLATA_POR_HIJOS;
    }
}