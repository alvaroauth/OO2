Este bad smell ocurre cuando un atributo de una clase esta publico. El problema con esto es que rompe completamente el encapsulamiento.
Esto separa los datos del comportamiento que los manipula, lo que reduce la modularidad del programa y lo hace propenso a errores
### Ejemplos

```java
public class cuentaBancaria{
	public double monto;
	public double limiteCredito;
}
```
>Los atributos publicos serian monto y limiteCredito, dejando asi que cualquier otra clase pueda modificarlos indiscriminadamente

### Refactoring
* [[Encapsulate Field]]
