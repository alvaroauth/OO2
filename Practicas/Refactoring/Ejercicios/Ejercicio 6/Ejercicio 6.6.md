![[Pasted image 20260412152227.png]]

1. Indique el mal olor.
2. Indique el refactoring que lo corrige.
3. Aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 

Si vuelve a encontrar un mal olor, retorne al paso 1.

```java
// Usuario.java
public class Usuario {
	String tipoSubscripcion;
    // ...
    
    public void setTipoSubscripcion(String unTipo) {
	    this.tipoSubscripcion = unTipo;
    }

    public double calcularCostoPelicula(Pelicula pelicula) {
	    double costo = 0;
	    if (tipoSubscripcion=="Basico") {
		    costo = pelicula.getCosto() + 
					pelicula.calcularCargoExtraPorEstreno();
	    }
	    else if (tipoSubscripcion== "Familia") {
		    costo = (pelicula.getCosto() + 
				     pelicula.calcularCargoExtraPorEstreno()) * 0.90;
	    }
	    else if (tipoSubscripcion=="Plus") {
		    costo = pelicula.getCosto();
	    }
	    else if (tipoSubscripcion=="Premium") {
		    costo = pelicula.getCosto() * 0.75;
	    }
	    return costo;
    }
}
```

```java
//Pelicula.java
public class Pelicula {
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
	    return this.costo;
	}

	public double calcularCargoExtraPorEstreno(){
		// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
		return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) >
																 30 ? 0 : 300;
    }
}
```

### Bad Smells 
- **Switch Statement:** Hay una cadena muy grande de if - else if que hacen el codigo dificil de seguir
- **Comments:** El codigo no es auto explicativo, por lo  que hace uso de comentarios
- **Magic Numbers:** 30, 0 y 300
- **Primitive Obsession**: Quiere representar el tipo de suscripcion con un string cuando este tiene comportamiento propio
### Refactorings
- **Replace Data value with Object**
- **Replace Conditional with Polymorphism**
- **Replace Magic number with Symbolic constant**
- **Extract method**: Para la parte de ChronoUnit.DAYS. ...
- **Move method**
### Codigo arreglado
```java
// Usuario.java
public class Usuario {
	private TipoSubscripcion tipoSub;
    // ...
    
    public void setTipoSubscripcion(TipoSubscripcion ts) {
	    this.tipoSub = ts;
    }

    public double calcularCostoPelicula(Pelicula pelicula) {
	    return tipoSub.calcularCosto(pelicula);
    }
}
```

```java
// TipoSubscripcion.java
public interface TipoSubscripcion {
	public double calcularCosto(Pelicula p);
}
```

```java
// SubscripcionBasica.java
public class SubscripcionBasica implements TipoSubscripcion{
	public double calcularCosto(Pelicula p) {
		return p.getCosto() + p.calcularCargoExtraPorEstreno();
	}
} 
```

```java
// SubscripcionFamiliar.java
public class SubscripcionPlus implements TipoSubscripcion{
	private static final double COEF_DESCUENTO = 0.90;
	
	public double calcularCosto(Pelicula p) {
		return (p.getCosto() + p.calcularCargoExtraPorEstreno()) * COEF_DESCUENTO;
	}
} 
```

```java
// SubscripcionPlus.java
public class SubscripcionFamiliar implements TipoSubscripcion{
	
	public double calcularCosto(Pelicula p) {
		return p.getCosto();
	}
} 
```

```java
// SubscripcionPremium.java
public class SubscripcionFamiliar implements TipoSubscripcion{
	private static final double COEF_DESCUENTO = 0.75;	
	
	public double calcularCosto(Pelicula p) {
		return p.getCosto() * COEF_DESCUENTO;
	}
} 
```

```java
//Pelicula.java
public class Pelicula {
	private static final double CARGO_ESTRENO = 300.0;
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
	    return this.costo;
	}

	public double calcularCargoExtraPorEstreno(){
		return esEstreno()? 0 : CARGO_ESTRENO;
    }
    
    private boolean esEstreno(){
	    return ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) > 30;
    }
}
```
