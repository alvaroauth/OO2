**Observe el siguiente código:**
```java
// Etiqueta.java
public abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }
}
```

```java
// EtiquetaSimple.java
public class EtiquetaSimple extends Etiqueta {

    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA BÁSICA ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio: $" + precio);
        System.out.println("-----------------------");
    }
}
```

```java
// EtiquetaDetalle.java
public class EtiquetaDetalle extends Etiqueta {

    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        System.out.println("--- ETIQUETA DETALLE ---");
        System.out.println("Producto: " + nombreProducto);
        System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("Precio final: $" + precio);
        System.out.println("-----------------------");
    }
}
```

> 1. **¿Hay código duplicado? Indique claramente en qué líneas se encuentra.**

Hay codigo duplicado en el generar, especificamente:
- `System.out.println("Producto: " + nombreProducto);`
- `System.out.println("-----------------------");`

> 2. **Se quiere aplicar el refactoring Pull Up Method para subir el método generar() a la superclase Etiqueta. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.**

Se requiere hacer un `Extract Method` de los comportamientos comunes, ahi nos faltaria resolver que el codigo que no se repite queda en medio de el codigo comun de ambos comportamientos. Para resolver esto podemos hacer un `Form Template Method` con la informacion especifica de cada etiqueta

> 3. **Mencione los refactorings previos necesarios para que sea posible aplicar Pull Up Method.**

Se tienen que hacer `Extract Method` y `Form Template Method`, quedaria asi:

```java
// EtiquetaSimple.java
public class EtiquetaSimple extends Etiqueta {

    public EtiquetaSimple(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        this.imprimirEncabezado();
        System.out.println("Producto: " + nombreProducto);
        this.imprimirInformacionEspecifica();
        System.out.println("-----------------------");
    }
    
    @Override
    protected void imprimirEncabezado(){
	    System.out.println("--- ETIQUETA BASICA ---");
    }
	
	@Override
	   protected void imprimirInformacionEspecifica(){
	    System.out.println("Precio: $" + precio);
    }
}
```

```java
// EtiquetaDetalle.java
public class EtiquetaDetalle extends Etiqueta {

    public EtiquetaDetalle(String nombre, double precio) {
        super(nombre, precio);
    }

    public void generar() {
        this.imprimirEncabezado();
        System.out.println("Producto: " + nombreProducto);
        this.imprimirInformacionEspecifica();
        System.out.println("-----------------------");
    }
    
    @Override
    protected void imprimirEncabezado(){
	    System.out.println("--- ETIQUETA DETALLE ---");
    }
	
	@Override
	   protected void imprimirInformacionEspecifica(){
	    System.out.println("Precio sin imp.: $" + (precio * 0.79));
        System.out.println("Precio final: $" + precio);
    }
}
```

> 4. **Aplique Pull Up Method para subir el método generar() a la superclase Etiqueta.**

```java
// Etiqueta.java
public abstract class Etiqueta {
    protected String nombreProducto;
    protected double precio;

    public Etiqueta(String nombre, double precio) {
        this.nombreProducto = nombre;
        this.precio = precio;
    }
    
    public void generar() {
        this.imprimirEncabezado();
        System.out.println("Producto: " + nombreProducto);
        this.imprimirInformacionEspecifica();
        System.out.println("-----------------------");
    }
    
    protected abstract void imprimirInformacionEspecifica();
    protected abstract void imprimirEncabezado();
}
```