package Ejercicio01.Ejercicio_01;

import java.util.*;

public class Twitter {
	private List<Usuario> usuarios;
	
	public Twitter() {usuarios = new ArrayList<>();}
	
	public boolean agregarUsuario(Usuario u) {
		if (this.usuarios.stream().anyMatch(usr -> usr.getScreenName().equals(u.getScreenName())))
			return false;
		usuarios.add(u);
		return true;
	}
	
	public boolean eliminarUsuario(Usuario u) {
		u.eliminarTodosLosTweets();
		return usuarios.remove(u);
	}
}