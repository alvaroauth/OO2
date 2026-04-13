package ar.edu.unlp.info.oo2.Ejercicio06_02;

public class Jugador {
	private static final int PUNTUACION_POR_PERDER = 50;
	private static final int PUNTUACION_POR_GANAR = 100;
	
	@SuppressWarnings("unused")
	private String nombre;
	@SuppressWarnings("unused")
	private String apellido;
	@SuppressWarnings("unused")
	private int puntuacion = 0;
	
	public Jugador (String nom, String ape) {
		nombre = nom;
		apellido = ape;
	}
	
	public void incrementar() {
		this.puntuacion += PUNTUACION_POR_GANAR;
	}
	
	public void decrementar() {
		this.puntuacion -= PUNTUACION_POR_PERDER;
	}
}
