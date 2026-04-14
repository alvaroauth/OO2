Este refactoring se hace cuando tenes un elemento de un dato que necesita comportamientos adicionales y decidis convertirlo en un objeto
Si estos datos se dejan como primitivos y ponemos los metodos del comportamiento en la clase que lo contiene, al toque salta la ficha de otros bad smell como por ejemplo *Duplicate Code* o *Feature Envy*

### Pasos
##### Paso 1
Crear una nueva clase para el valor, agregarle un campo `final` del mismo tipo que tenia el valor original. Agregarle getter y constructor
##### Paso 2
Compila y fijate si no rompiste nada
##### Paso 3
Cambiale el campo en la clase original que antes era un primitivo o String por la nueva clase que creaste 
##### Paso 4 
Actualiza el getter original para q llame al nuevo getter y el constructor cambialo para q llame al constructor nuevo. Tambien si habia un metodo de obtencion asegurate q ahora cree una instancia del objeto nuevo
##### Paso 5
Compila y testea de nuevo

### Ejemplo
```java
public class Pedido {
    private String cliente;

    public Pedido(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
```

##### Paso 1
```java
public class Cliente {
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
```
##### Paso 2
No se rompio nada vamoo

##### Paso 3
```java
public class Pedido {
    private Cliente cliente;
}
```

##### Paso 4
```java
	public Pedido(String nombreCliente) {
	    this.cliente = new Cliente(nombreCliente);
	}
	
	public String getClienteNombre() {
	    return cliente.getNombre();
	}
```

#### Resultado final
```java
// Nueva clase que encapsula el dato
public class Cliente {
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase origen actualizada
public class Pedido {
    private Cliente cliente;

    public Pedido(String nombreCliente) {
        this.cliente = new Cliente(nombreCliente);
    }

    public String getClienteNombre() {
        return cliente.getNombre();
    }

    public void setCliente(String nombreCliente) {
        this.cliente = new Cliente(nombreCliente);
    }
}
```
