package ar.edu.unlp.info.oo1.Ejercicio06;

public class EmpleadoPasante extends Empleado{
    public EmpleadoPasante(String nombre, String apellido, double sueldoBasico) {
		super(nombre, apellido, sueldoBasico);
	}

	protected double sueldoEspecifico() {
		return 0;
	}
}