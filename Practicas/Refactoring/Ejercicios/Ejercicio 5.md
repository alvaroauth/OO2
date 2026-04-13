Utilizando los extractos de codigo de el proyecto Ejecicio-05:
>1. **La variable “cost” está declarada como pública, lo que rompe el encapsulamiento de la clase. Utilice el refactoring Encapsulate Field y describa brevemente los pasos llevados a cabo. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante:**


>a. **¿Es correcto modificar alguno de los tests para que el código refactorizado funcione?**

Es correcto mientras no me modifiquen los comportamientos de manera que la logica del programa sea distinta. En otras palabras, pueden cambiar la manera de hacer las cosas pero no el resultado final

> b. **En caso de qué el test falle, ¿qué situación está representando este test?**

Puede representar que se cambio la manera de hacer las cosas en el codigo, como por ejemplo un encapsulate field y no se hizo bien el refactoring, es decir, no se siguieron los pasos adecuadamente ya que por ejemplo, quedaron referencias a ese campo antes publico

>2. **Utilice el refactoring Rename Field en el método priceFactor(), para que la variable “cost” se pase a llamar “quote”. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: ¿en este caso, es necesario modificar alguno de los tests para que el código refactorizado funcione?**

El programa quedaria asi:

```java

public class HotelStay extends Product {
    public double quote;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double quote, TimePeriod timePeriod, Hotel hotel) {
        this.quote = quote;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() *                                                        this.hotel.discountRate();
    }
}
```

Habria que modificar el constructor con un `Rename Parameter` ya que dejaria de tener sentido que el parametro se llame cost, y las otras apariciones serian en el constructor y en la declaracion donde tambien habria que modificarlo
**Hace falta cambiar el test** ya que no estariamos cambiando al logica sino la manera de acceder a los datos, se deberia hacer un refactoring para encapsular el campo publico

> 3. **Se quiere aplicar el refactoring Pull Up Method para subir los métodos startDate() y endDate() a la superclase Product. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.**

Si, se puede hacer ya que comparten una superclase y la firma y comportamiento de los metodos es el mismo, lo unico que nos limita es el campo timePeriod, pero al ser identico en ambos podemos hacer un *Pull-Up Field* 

> 5. **Aplique Pull Up Method para subir los métodos a la superclase Product. Verifique que los tests provistos sigan funcionando.**

```java
// Product.java
public abstract class Product {
    public TimePeriod timePeriod;

    public Product(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }
    
    public LocalDate endDate() {
        return this.timePeriod.end();
    }
}
```

```java
// HotelStay.java
public class HotelStay extends Product {
    public double cost;
    private Hotel hotel;

    public HotelStay(double c, TimePeriod tp, Hotel h) {
        super(tp);
        this.cost = c;
        this.hotel = h;
	}

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}
```

```java
// CarRental.java
public class CarRental extends Product {
    public double cost;
    private Company company;

    public CarRental(double cost, TimePeriod tp, Company company) {
        super(tp);
        this.cost = cost;
        this.company = company;
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double cost() {
        return this.cost;
    }
}
```

Aplicamos un *Pull-Up Field* en `timePeriod`, un *Pull-Up Constructor Body* en ambas clases, y el *Pull-Up Method* correspondiente.

> 6. **Observe los métodos price() en CarRental.java (línea 21) y en HotelStay.java (línea 25). Identifique los Code Smell presentes. Luego aplique los refactoring correspondientes para eliminarlos. Verifique que los tests provistos sigan funcionando.**

Se pueden observar los siguientes code smells:
- Duplicate code: En la firma del metodo
- Feature Envy: Esto pasa ya que ambos calculan el precio con cosas que solo dependen de `Company` y `Hotel`, dejando claro que es algo de lo que podrian encargarse las mismas clases