package Ejercicio01.Ejercicio_01;

import java.util.*;

public class Tweet {
	private String cuerpo;
	private Set<Usuario> usuariosRT;
	
	public Tweet(String c) {
		this.cuerpo = c;
		this.usuariosRT = new HashSet<>();
	}
	
	public String getCuerpo() {
		return this.cuerpo;
	}
	
	public void eliminarRetuits() {
		for (Usuario u : usuariosRT){
			u.eliminarRetweets(this);
		}
	}
	
	public void agregarUsuarioRT(Usuario u) {
		usuariosRT.add(u);
	}
}