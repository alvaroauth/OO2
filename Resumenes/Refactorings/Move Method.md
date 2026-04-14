Este refactoring se usa cuando un metodo esta usando una o mas caracteristicas de una clase diferente a la clase donde esta definido.
Consiste en crear un nuevo metodo con cuerpo similar en la clase destino.
### Pasos
> ==Clase destino = Clase con la que mas interactua==
##### Paso 1
Se declara el metodo en la clase destino y se copia el cuerpo adaptado a esta clase
##### Paso 2
El metodo original se convierte en una delegacion del nuevo metodo, se prueba y se compila
##### Paso 3
Se puede remover el metodo original y reemplazar en todos lados donde aparezca por el nuevo nombre y objeto del metodo (esto es opcional).

### Ejemplo
##### Codigo original
```java
public class Person {
    private String nombre;
    private String codArea;
    private String numeroTel;

    public String getNombre() {
        return nombre;
    }

    public String getTelephoneNumber() {
        return ("(" + codArea + ") " + numeroTel);
    }

    // ... (getters y setters del código de área y número)
}
```

Aca como el comportamiento del telefono es una responsabilidad por si misma, se crea una clase separada (*Exctact Class*), despues se aplica *Move Field* y en clase Person dejamos solo la referencia al objeto numero de telefono
Ahora tenemos el problema de que al no haber aplicado todavia el *Move Method* se sigue dependiendo de los getters de `Telefono`, esto genera un **Feature Envy** desde `Person` hacia `Telefono`.
Para esto, copiamos el metodo `getTelephoneNumber`, osea *Move Method* y copiamos el cuerpo original al nuevo metodo adaptandolo.

```java
public class TelephoneNumber {
    private String codArea;
    private String numeroTel;

    // El método fue movido aquí (Move Method)
    public String getTelephoneNumber() {
        return ("(" + codArea + ") " + numeroTel);
    }

    // ... (getters y setters del código de área y número)
}
```

```java
public class Person {
    private String nombre;
    private TelephoneNumber telefono = new TelephoneNumber();

    public String getNombre() {
        return nombre;
    }

    public String getTelephoneNumber(){
        return telefono.getTelephoneNumber();
    }
}
```