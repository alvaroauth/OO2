Este bad smell ocurre cuando se utilizan estructuras de iteracion tradicionales como `for` y `while` para procesar colecciones de datos en lugar de aprovechar los **streams** y similares.
Esto da como resultado un **codigo mucho mas extenso y menos expresivo**.

### Ejemplos

```java
public List<String> obtenerNombresActivos(List<Empleado> empleados) {
    List<String> nombresActivos = new ArrayList<>();
    for (int i = 0; i < empleados.size(); i++) {
        Empleado emp = empleados.get(i);
        if (emp.isActive()) {
            nombresActivos.add(emp.getName());
        }
    }
    return nombresActivos;
}
```

```java
private static int numberOfOrdersFor(Collection orders, String customer) {
    int result = 0;
    Iterator iter = orders.iterator();
    while (iter.hasNext()) {
        Order each = (Order) iter.next();
        if (each.getCustomerName().equals(customer)) result++;
    }
    return result;
}
```

## Refactoring
- [[Replace Loop with Pipeline]]
