# Envio de Pedidos
![[Pasted image 20260411191429.png]]

1. Indique el mal olor.
2. Indique el refactoring que lo corrige.
3. Aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 

Si vuelve a encontrar un mal olor, retorne al paso 1.

```java
// Supermercado.java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });
     
	 // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}
```

```java
public class Cliente {
   public String getDireccionFormateada() {
		return this.direccion.getLocalidad() + “, ” +
				this.direccion.getCalle() + “, ” +
				this.direccion.getNumero() + “, ” +
				this.direccion.getDepartamento();
	}
}
```

### Bad smells
- **Feature envy:** cliente se encarga de formatear la direccion cuando el encargado de eso deberia ser la propia direccion
- **Comments:** Se deben usar comentarios para explicar que hace el choclo de codigo del metodo
### Refactoring
- **Move Method:** Pasar el metodo getDireccionFormateada() a la clase direccion
- **Extract Method:** Hacer que la creacion del mensaje se separe de informar el mismo para generar autoexplicacion.

```java
// Supermercado.java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente c) {
     System.out.println(this.generarMensaje(nroPedido, c));
  }
  
  private String generarMensaje(long nroPedido, Cliente c){
	  return MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, c.getDireccionFormateada() });
  }
}
```

```java
public class Cliente {
   public String getDireccion() {
		return this.direccion.formatearDireccion();
	}
}
```

```java
public class Direccion{
	private String localidad;
	private String calle;
	private int numero;
	private String departamento;
	
	// getters y setters...
	
	public String formatearDireccion(){
		return this.getLocalidad() + “, ” +
				this.getCalle() + “, ” +
				this.getNumero() + “, ” +
				this.getDepartamento();
	}
}
```

