Es un bad smell que advierte que los comentarios a menudo se utilizan para cubrir codigo que es malo (complejo o mal escrito). El codigo comentado suele ser codigo **que no logra explicarse por si mismo**.

>Los comentarios si sirven para explicar para indicar areas del codigo donde hay dudas o para explicar el porque se tomaron ciertas decisiones

## Ejemplos

```java
// Comprueba si el empleado tiene derecho a un bono de fin de año basado en su antigüedad, si está activo y su tipo de contrato. 
if (emp.getDias() > 365 && emp.getEstado() == true && emp.getTipo().equals("F")) {
	otorgarBono(emp); 
}
```

```java
int d; // Días transcurridos desde la creación de la cuenta 
List<Factura> l1; // Lista de facturas impagas
```

```java
// Si el estado es 4, significa que el usuario está baneado 
if (usuario.getEstado() == 4) {
	bloquearAcceso(usuario); 
}
```

- [[Rename Method]]
- 