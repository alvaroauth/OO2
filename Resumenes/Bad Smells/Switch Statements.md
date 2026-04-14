Este bad smell se refiere al uso excesivo de condiciones complejos (switch o cadenas grandes de if - else) que deberian ser reemplazados. El principal problema es la duplicacion, ya que en sistemas con este smell es comun encontrar el mismo switch varias veces. Esto hace que si se quiere modificar uno de estos tengas que buscar todas las repeticiones

### Ejemplo
```java
public class LiquidadorSueldos {
    public double calcularSueldo(Empleado empleado)
        switch (empleado.getTipo()) {
            case "PROGRAMADOR_JUNIOR":
                return empleado.getSueldoBase() * 1.10;
            case "PROGRAMADOR_SENIOR":
                return empleado.getSueldoBase() * 1.50 + 
				        empleado.getBono();
            case "PROJECT_MANAGER":
                return empleado.getSueldoBase() * 2.0 + 
		                empleado.getBonoEquipo();
            default:
                throw new IllegalArgumentException
                ("Tipo de empleado desconocido");
        }
    }
}
```

### Refactoring
- [[Replace Conditional with Polymorphism]]

