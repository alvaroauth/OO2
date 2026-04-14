Este refactoring consiste en crear un nuevo atrivuto en la clase destino y cambiar todas las referencias para que apunten a este nuevo lugar, esto ocurre cuando un atributo sera mas utilizado por otra clase mas que por si misma.
Se debe aplicar cuando se nota que los metodos de una clase acceden a un atributo de tu clase con mayor frecuencia que vos mismo

### Pasos
##### Paso 1
Crear el atributo en la clase destino junto con getters y setters
##### Paso 2
Determinar como la clase de donde queremos remover el atributo va a acceder al mismo (puede ser que haya que crear un enlace)
##### Paso 3
Eliminar el atributo de la clase original
##### Paso 4
Reemplazar todas las referenciasd el viejo atributo a la clase del nuevo
##### Paso 5
Compilar y ver que pase todos los tests bien

### Ejemplo
```java
public class Cuenta {
    private TipoCuenta tipo;
    private double tasaInteres; // Este es el atributo a mover

    public double interesPorCantidadDeDias(double cant, int dias) {
        return tasaInteres * cant * dias / 365;
    }
}
```

##### Paso 1
Crear el atributo en la clase destino con getters y setters
```java
public class TipoCuenta {
    private double tasaInteres;

    public void setTasaInteres (double arg) {
        tasaInteres = arg;
    }
    double getTasaInteres () {
        return tasaInteres;
    }
}
```
##### Paso 2
Cambiar las referencias y la clase donde se usaba, no hubo que crear un enlace porque ya habia
```java
public class Cuenta {
    private TipoCuenta tipo;

    double interesPorCantidadDeDias(double cant, int dias) {
        return tipo.getTasaInteres() * cant * dias / 365;
    }
}
```