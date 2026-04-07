package Ejercicio01.Ejercicio_01;
import java.util.*;
import java.util.stream.Collectors;
public class Usuario {
	private String screenName;
	private List<Tweet> tuits;
	private List<Tweet> retuits;
	
	public Usuario(String sn) {
		this.screenName = sn;
		this.tuits = new ArrayList<>();
		this.retuits = new ArrayList<>();
	}
	
	public String getScreenName() {
		return screenName;
	}
	
	public boolean tuitear(Tweet t) {
		if(t == null || (t.getCuerpo().length() < 1 && t.getCuerpo().length() > 280))
			return false;
		tuits.add(t);
		return true;
	}
	
	public boolean retuitear(Tweet t) {
		if(t == null || (t.getCuerpo().length() < 1 && t.getCuerpo().length() > 280))
			return false;
		retuits.add(t);
		t.agregarUsuarioRT(this);
		return true;
	}
	
	public void eliminarRetweets(Tweet t) {
		this.retuits.stream().filter(rt -> !(rt.equals(t))).collect(Collectors.toList());
	}
	
	public boolean eliminarTweet(Tweet t) {
		t.eliminarRetuits();
		return this.tuits.remove(t);
	}
	
	public void eliminarTodosLosTweets() {
		tuits.stream().forEach(t -> eliminarTweet(t));
	}
}
