Este refactoring se hace cuando queremos pasar un atributo de publico a privado, para esto generamos metodos de acceso (getters y setters).
##### Teniendo este codigo
```java
public class Persona{
	public String nombre;
	//...
}
```

##### Paso 1
Creamos un metodo de obtencion y establecimiento (get y set) para el campo
```java
public class Persona{
	public String nombre;
	//...
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void setNombre(String nom){
		this.nombre = nom;
	}
	//...
}
```

##### Paso 2 
Buscamos todas las referencias al campo dentro del codigo y evaluamos si se reemplaza por un getter o un setter 
##### Paso 3
Compilar y probar el codigo con los cambios, verificar que pase todos los test
##### Paso 4
Cambiar el campo de publico a privado