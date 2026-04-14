Es un refactoring que se utiliza cuando las subclases poseen metodos que realizan **exactamente el mismo trabajo o producen resultados identicos**, consiste en mover ese metodo a la superclase comun. Su principal motivacion es eliminar codigo duplicado.
El caso mas facil es cuando son identicos, pero otras veces requiere trabajo previo, por ejemplo parametrizarlos para igualarlos o usar tecnicas como *Form Template Method*
## Ejemplo
Codigo original
```java
public abstract class Vehiculo {
    protected boolean motorEncendido = false;
    protected Motor motor;
}

public class Auto extends Vehiculo {
    public void arrancar() {
        motorEncendido = true;
		motor.start();
    }
}

public class Moto extends Vehiculo {
    public void arrancar() {
        motorEncendido = true;
        motor.start();
    }
}
```

##### Paso 1
Verficamos que ambos metodos hacen exactamente lo mismo, tienen la misma firma y no hacen llamadas a atributos exclusivos de las subclases

> En caso de que esto no sea asi, pueden usarse diversos refacrtorings para solucionar esto, como *Form Template Method*, *Parameterize Method*, *Rename Method*, etc.

##### Paso 2
Creamos el metodo en la superclase vehiculo, copiando el contenido y el codigo duplicado

>En caso de que no exista una superclase comun, se puede aplicar *Exctract Superclass*, *Exctract Class* o verificar realmente donde pertenece el metodo

##### Paso 3
Pasamos la logica al nuevo metodo y hacemos que el viejo llame al nuevo, compilamos y comprobamos que los test den bien

##### Paso 4
Eliminamos el metodo anterior y cambiamos todas las referencias del viejo metodo al nuevo. Repetimos todo este proceso para cada metodo

##### Codigo final
```java
abstract class Vehiculo {
    protected boolean motorEncendido = false;
    protected Motor motor;
    
    public void arrancar() {
        motorEncendido = true;
        motor.start();
    }
}

class Auto extends Vehiculo {
    // El método arrancar() fue eliminado
}

class Moto extends Vehiculo {
    // El método arrancar() fue eliminado
}
```

