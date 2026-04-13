>**Producto.java**
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}
```

>**ItemCarrito.java**
```java
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
}
```

>**Carrito.java**
```java
public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
		return this.items.stream()
			.mapToDouble(item -> 
				item.getProducto().getPrecio() * item.getCantidad())
				.sum();
    }
}
```

# Bad Smells
- **Feature Envy:** Carrito quiere encargarse de calcular el total teniendo que pedirle al producto y al item atributos
- **Message chains:** Carrito tiene que mandarle mensaje a item y luego a producto
# Refactoring
- **Exctract method:** Hacer el metodo calcularTotal() en Carrito
- **Move method:** El nuevo metodo creado pasarlo a la clase ItemCarrito
# Codigo arreglado

>**Producto.java**
```java
public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }
}
```

>**ItemCarrito.java**
```java
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }
    
    public double getTotal(){
		return producto.getTotal() * cantidad;
	}
}
```

>**Carrito.java**
```java
public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
		return this.items.stream()
			.mapToDouble(item -> 
				item.getTotal())
				.sum();
    }
}
```
