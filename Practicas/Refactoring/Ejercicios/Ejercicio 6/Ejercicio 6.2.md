>**Juego.java**
```java
public class Juego {
// ...
	public void incrementar(Jugador j) {
		j.puntuacion = j.puntuacion + 100;
	}

	public void decrementar(Jugador j) {
		j.puntuacion = j.puntuacion - 50;
	}

}
```

>**Jugador.java**
```java
public class Jugador {
	public String nombre;
	public String apellido;
	public int puntuacion = 0;
}
```

# Bad Smells
* **Public Field:** Los atributos en la clase jugador estan publicos
* **Feature envy:** Juego quiere tomar la responsabilidad de aumentar y decrementar puntuaciones propias del jugador
* **Magic numbers:** Los numeros 50 y 100 no se entiende de donde vienen
# Refactoring
* **Encapsulate Field:** Pasar nombre, apellido y puntuacion a privados
* **Move Method:** Mover los metodos `incrementar` y `decrementar` a jugador.
* **Replace magic numbers with symbolic constant:** Pasar 100 y 50 a constantes con nombres autoexplicativos

# Codigo arreglado

>**Juego.java**
```java
public class Juego {
	public void incrementar(Jugador j) {
		j.incrementar();
	}
	
	public void decrementar(Jugador j) {
		j.decrementar();
	}
}
```

>**Jugador.java**
```java
public class Jugador {
	private static final int PUNTUACION_POR_PERDER = 50;
	private static final int PUNTUACION_POR_GANAR = 100;

	private String nombre;
	private String apellido;
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
```
