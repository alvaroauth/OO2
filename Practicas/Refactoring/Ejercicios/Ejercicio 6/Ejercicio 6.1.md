> Para cada una de las siguientes situaciones, realice en forma iterativa los siguientes pasos:
    (i) indique el mal olor,
    (ii) indique el refactoring que lo corrige, 
    (iii) aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 
   Si vuelve a encontrar un mal olor, retorne al paso (i).

>**EmpleadoTemporario.java**
```java
public class EmpleadoTemporario {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	public double horasTrabajadas = 0;
	public int cantidadHijos = 0;
	// ......

	public double sueldo() {
		return this.sueldoBasico
		+(this.horasTrabajadas * 500)
		+(this.cantidadHijos * 1000)
		-(this.sueldoBasico * 0.13);
	}
}
```

>**EmpleadoPlanta.java**
```java
public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......

    public double sueldo() {
        return this.sueldoBasico 
		+ (this.cantidadHijos * 2000)
		- (this.sueldoBasico * 0.13);
    }
}
```

> **EmpleadoPasante.java**
```java
public class EmpleadoPasante {
	public String nombre;
	public String apellido;
	public double sueldoBasico = 0;
	// ......
	public double sueldo() {
		return this.sueldoBasico - (this.sueldoBasico * 0.13);
	}
}
```

# Bad smells
- **Public fields:** Las v.i. estan todas publicas, esto rompe el encapsulamiento
- **Duplicate Code:** nombre, apellido y sueldo basico esta en las 3 clases
- **Alternative Classes with Different Interfaces:** No se puede aplicar polimorfismo a empleado
- **Magic numbers:** 0.13, 500, 1000, etc.

# Refactoring
- **Encapsulate field:** Hacer privados las v.i.
- **Pull-up Fields:** Subir a una superclase las v.i. repetidas
- **Pull-up Method:** Subir a una superclase los metodos repetidos
- **Form template method:** Hacer un metodo con la logica general y separar lo especifico
- **Replace magic numbers with symbolic constants:** Hacer constantes los numeros q no se entiende de donde vienen
### Codigo arreglado
```java
public abstract class Empleado {
    // Encapsulate Field + Pull-up Fields
    private String nombre;
    private String apellido;
    private double sueldoBasico;

    // Replace magic numbers with symbolic constants
    protected static final double PORCENTAJE_DESCUENTO = 0.13;

    public Empleado(String nombre, String apellido, double sueldoBasico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldoBasico = sueldoBasico;
    }

    public final double sueldo() {
        return this.getSueldoBasico() + this.calcularAdicionales() - this.calcularDescuentos();
    }

    protected double calcularDescuentos() {
        return this.getSueldoBasico() * PORCENTAJE_DESCUENTO;
    }
    
	// Form template method
    protected abstract double calcularAdicionales();

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}
```

```java
public class EmpleadoTemporario extends Empleado {
    private double horasTrabajadas;
    private int cantidadHijos;

    private static final double VALOR_HORA = 500;
    private static final double ADICIONAL_POR_HIJO = 1000;

    public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico, double horasTrabajadas, int cantidadHijos) {
        super(nombre, apellido, sueldoBasico);
        this.horasTrabajadas = horasTrabajadas;
        this.cantidadHijos = cantidadHijos;
    }

    @Override
    protected double calcularAdicionales() {
        return (this.horasTrabajadas * VALOR_HORA) + (this.cantidadHijos * ADICIONAL_POR_HIJO);
    }
}
```

```java
public class EmpleadoPlanta extends Empleado {
    private int cantidadHijos;

    private static final double ADICIONAL_POR_HIJO = 2000;

    public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantidadHijos) {
        super(nombre, apellido, sueldoBasico);
        this.cantidadHijos = cantidadHijos;
    }

    @Override
    protected double calcularAdicionales() {
        return this.cantidadHijos * ADICIONAL_POR_HIJO;
    }
}
```

```java
public class EmpleadoPasante extends Empleado {

    public EmpleadoPasante(String nombre, String apellido, double sueldoBasico) {
        super(nombre, apellido, sueldoBasico);
    }

    @Override
    protected double calcularAdicionales() {
        return 0; 
    }
}
```
