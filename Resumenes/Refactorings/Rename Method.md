Consiste en cambiarle el nombre a un metodo, esto implica renombrar todas las apariciones del metodo en todo el codigo, siguiendo una serie de pasos

##### Teniendo este codigo original
Queremos renombrar el metodo como `getNombreCompleto()`
```java
public String getInf(){
	return this.apellido + ", " + this.nombre;
}
```

##### Paso 1
Crear un nuevo metodo y delegar, ya que si cambiamos todo de golpe podriamos romper el codigo, quedaria asi temporalmente

```java
public String getInf(){
	return this.getNombreCompleto();
}

public String getNombreCompleto(){
	return this.apellido + ", " + this.nombre;
}
```

##### Paso 2
Ahora todas las referencias que estaban en `getInf()` hay que pasarlas a `getNombreCompleto()`, para esto hay que buscar en todo el codigo y actualizar una por una para que llamen al nuevo metodo. Se vuelve a probar el programa y se verifica que no de ningun error de compilacion
##### Paso 3
Se elimina el metodo viejo, quedando asi solo el nuevo metodo con el nombre que queremos
```java
public String getNombreCompleto(){
	return this.apellido + ", " + this.nombre;
}
```