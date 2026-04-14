Este refactoring consiste en tomar un fragmento de codigo que puede ser agrupado logicamente y convertirlo en un nuevo metodo independiente. La regla mas importante es que **el nombre de este nuevo metodo debe explicar el proposito o la intencion del codigo** en lugar de describir como lo hace.
Se usa para combatir metodos largos, eliminar comentarios, incrementar la legibilidad y el reuso
### Pasos
##### Paso 1
Crear un nuevo metodo cuyo nombre explique claramente su proposito
##### Paso 2
Copiar el codigo que se quiere extraer hacia el nuevo metodo
##### Paso 3
Revisar las variables locales del fragmento de codigo, si alguna se usa solo dentro de este pedazo se mueve ahi, en caso contrario se pasa como parametro
##### Paso 4
Reemplazar el codigo extraido en el metodo original por la llamada al nuevo metodo
##### Paso 5
Compilar y ver q pase todos los tests como antes

### Ejemplo
##### Codigo original
```java
public void imprimirReciboMensual(String nombreCliente, List<Cuota> cuotas) {
	System.out.println("**** GIMNASIO - RECIBO MENSUAL ****");
    
    double deudaTotal = 0.0;
    
    for (Cuota cuota : cuotas) {
        if (!cuota.estaPagada()) {
            deudaTotal += cuota.getMonto();
        }
    }

    System.out.println("Cliente: " + nombreCliente);
    System.out.println("Deuda pendiente: $" + deudaTotal);
}
```

##### Paso 1
Crear nuevo metodo
```java
private double calcularDeudaPendiente() {
    // Método vacío por ahora
}
```

##### Paso 2
Copiar el codigo extraido al nuevo metodo
```java
public double calcularDeudaPendiente() {
	double deudaTotal = 0.0;
    
    for (Cuota cuota : cuotas) {
        if (!cuota.estaPagada()) {
            deudaTotal += cuota.getMonto();
        }
    }
}
```

##### Paso 3
Analizamos las variables locales y parametros, deudaTotal podemos hacerla local y retornar el valor, la lista necesitamos peditla por parametro
```java
private double calcularDeudaPendiente(List<Cuota> cuotas) {
    double deudaTotal = 0.0;
    for (Cuota cuota : cuotas) {
        if (!cuota.estaPagada()) {
            deudaTotal += cuota.getMonto();
        }
    }
    return deudaTotal;
}
```

##### Paso 4
Hacer que el cacho de codigo viejo llame al nuevo metodo
```java
public void imprimirReciboMensual(String nombreCliente, List<Cuota> cuotas) {
	System.out.println("**** GIMNASIO - RECIBO MENSUAL ****");
    
    double deudaTotal = calcularDeudaPendiente(cuotas);

    System.out.println("Cliente: " + nombreCliente);
    System.out.println("Deuda pendiente: $" + deudaTotal);
}
```

