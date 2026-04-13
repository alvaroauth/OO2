# Enunciado
```java
/*
* Retorna el límite de crédito del cliente
*/
public double lmtCrdt() {...

/*
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double mtFcE(LocalDate f1, LocalDate f2) {...

/*
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double mtCbE(LocalDate f1, LocalDate f2) {...
```

# Solucion
```java
/*
* Retorna el límite de crédito del cliente
*/
public double limiteDeCredito() {...

/*
* Retorna el monto facturado al cliente desde la fecha f1 a la fecha f2
*/
protected double getMontoFacturado(LocalDate inicio, LocalDate fin) {...

/*
* Retorna el monto cobrado al cliente desde la fecha f1 a la fecha f2
*/
private double getMontoCobrado(LocalDate inicio, LocalDate fin) {...
```

# Explicacion
### Bad smells
* **Uncommunicative Name:** Los nombres no son autoexplicativos
### Refactoring
* **Rename method:** Renombrar los metodos para darle nombres mas legibles y autoexplicativos.
