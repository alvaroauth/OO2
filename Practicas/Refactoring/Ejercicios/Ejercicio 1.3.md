> **Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.**
```java
public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s",        promedioEdades, totalSalarios);
	
	System.out.println(message);
}
```

# Solucion
```java
public double getPromedioEdades(){
	return personal.stream()
	               .mapToInt(e -> e.getEdad())
	               .average()
	               .orElse(0);
}

public double getTotalSalarios(){
	return personal.stream() 
				   .mapToDouble(e -> e.getSalario())
				   .sum()
				   .orElse(0.0);
}
```

# Explicacion
### Bad smells
* **Long Method:** El metodo calcula varias cosas, no tiene una sola responsabilidad
* **Imperative Loops:** Recorre las listas imperativamente
* **Temporary fields:** Usa variables temporales
### Refactoring
- **Extract Method:** Divido el metodo en dos y que cada uno calcule un solo valor y lo retorne como parametro
- **Replace loop with pipeline:** Cambio el recorrido imperativo del for por un stream
- **Replace temp with query:** Saca las variables temporales y las cambia por consultas