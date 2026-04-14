Este bad smell pasa cuando se usan tipos de datos primitivos (int, string, double) para representar cosas mas complejas que tienen comportamiento por si mismo. No hay que caer en la tipica de no hacer un objeto nada mas porque es muy chico o tiene poco comportamiento.
Por ejemplo si se usa un string para el telefono cualquier logica de validacion, formateo o extraccion de codigo de area queda dispersa en las clases q lo usan
# Ejemplo
```java
public class Order {
    private String cliente;

    public Order (String cliente) {
        this.cliente = cliente;
    }
    
    public String getCliente() {
        return cliente;
    }
    
    public void setCliente(String arg) {
        this.cliente = arg;
    }
}
```
# Refactoring
- [[Replace Data Value with Object]] 