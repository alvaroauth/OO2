package ar.edu.unlp.info.oo1.Ejercicio06;

public class EmpleadoTemporario extends Empleado {
	private static final int PLATA_POR_HIJOS = 1000;
	private static final int PLATA_POR_HORAS_EXTRA = 500;
	
	private double horasTrabajadas = 0;
	private int cantidadHijos = 0;
	
	public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico, double horasTrabajadas, int cantidadHijos) {
		super(nombre, apellido, sueldoBasico);
		this.horasTrabajadas = horasTrabajadas;
		this.cantidadHijos = cantidadHijos;
	}
    
	protected double sueldoEspecifico() {
		return (horasTrabajadas * PLATA_POR_HORAS_EXTRA) + (cantidadHijos * PLATA_POR_HIJOS);
	}
}
