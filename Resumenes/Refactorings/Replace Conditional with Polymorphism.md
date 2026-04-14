Este refactoring consiste en eliminar condicionales complejos que, dependiendo del tipo del objeto actuan distinto. 
Consiste en mover cada rama del condicional a un metodo sobreescrito dentro de una subclase especifica, dejando el metodo original de la superclase como asbtracto. De esta manera, cuando se llama al metodo hace lo correcto segun su tipo. Ejemplo tener una superclase `Suscripcion` y que de ella deriven `Basica`, `Premium` y `Ultimate`, asi todas tienen un metodo `calcularCosto()`. Esto hace que un usuario pueda cambiar mas facilmente de suscripcion, asi como tambien cambiar mas facil el comportamiento de cada suscripcion

### Pasos
Si la sentencia condicional es una parte nada mas, se tiene que aislar con [[Extract Method]]
##### Paso 1
Por cada variante o caso del condicional, **debes crear un método en una subclase correspondiente que redefina el método de la superclase**
##### Paso 2
**Copiar el cuerpo de la rama del condicional** directamente a la subclase y ajustarlo para que funcione.
##### Paso 3
Repetir con todos, **compilar y testear** la aplicación
### Ejemplo

```java
public class TipoEmpleado {
    public int montoAPagar(Empleado emp) {
        switch (getCodigoTipo()) {
            case INGENIERO:
               return emp.getSalarioMensual();
            case VENDEDOR:
               return emp.getSalarioMensual() + emp.getComision();
            case GERENTE:
               return emp.getSalarioMensual() + emp.getBono();
            default:
               throw new RuntimeException("Empleado incorrecto");
        }
    }
}
```

Crear la clase ingeniero
```java
public class Ingeniero extends TipoEmpleado {
    public int montoAPagar(Empleado emp) {
        return emp.getSalarioMensual();
    }
}
```

Borrar la parte de ingeniero aca
```java
public class TipoEmpleado {
    public int montoAPagar(Empleado emp) {
        switch (getCodigoTipo()) {
            // La rama INGENIERO fue eliminada de aquí
            case VENDEDOR:
               return emp.getSalarioMensual() + emp.getComision();
            case GERENTE:
               return emp.getSalarioMensual() + emp.getBono();
            default:
               throw new RuntimeException("Empleado incorrecto");
        }
    }
}
```

Repetir todo el proceso con todos

```java
public class Vendedor extends TipoEmpleado {
    public int montoAPagar(Empleado emp) {
        return emp.getSalarioMensual() + emp.getComision();
    }
}

public class Gerente extends TipoEmpleado {
    public int montoAPagar(Empleado emp) {
        return emp.getSalarioMensual() + emp.getBono();
    }
}
```

Hacer abstracta la clase y el metodo

```java
public abstract class TipoEmpleado {
    public abstract int montoAPagar(Empleado emp);
}
```

Puede ser que antes de esto haya que aplicar cosas como *Exctract Class*, *Move Method*, etc.

### Otro ejemplo
```java
class Bird {
  // ...
  double getSpeed() {
    switch (type) {
      case EUROPEAN:
        return getBaseSpeed();
      case AFRICAN:
        return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
      case NORWEGIAN_BLUE:
        return (isNailed) ? 0 : getBaseSpeed(voltage);
    }
    throw new RuntimeException("Should be unreachable");
  }
}
```

Pasa a esto
```java
abstract class Bird {
  // ...
  abstract double getSpeed();
}

class European extends Bird {
  double getSpeed() {
    return getBaseSpeed();
  }
}
class African extends Bird {
  double getSpeed() {
    return getBaseSpeed() - getLoadFactor() * numberOfCoconuts;
  }
}
class NorwegianBlue extends Bird {
  double getSpeed() {
    return (isNailed) ? 0 : getBaseSpeed(voltage);
  }
}

// Somewhere in client code
speed = bird.getSpeed();
```
