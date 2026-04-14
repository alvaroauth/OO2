Este refactoring soluciona el bad smell [[Magic Numbers]], buscando reemplazar todos esos numeros sueltos que no se entienden de donde vienen por constantes con nombres autoexplicativos, haciendo asi que no haya que investigar de donde viene un numero sino simplemente leer el nombre de la constante.
### Ejemplos

```java
double calcularSueldoReal(double sueldoBruto){
	return sueldoBruto - (sueldoBruto * 0.21);
}
```
>Refactorizamos
```java
private static final double COEF_SUELDO_REAL = 0.21;

double calcularSueldoReal(double sueldoBruto){
	return sueldoBruto - (sueldoBruto * COEF_SUELDO_REAL);
}
```

---

```java
double energiaPotencial(double mass, double height){
	return mass * 9.81 * height;	
}
```
>Refactorizamos
```java
private static final double CONSTANTE_GRAVITACIONAL = 9.81;

double calcularSueldoReal(double sueldoBruto){
	return mass * CONSTANTE_GRAVITACIONAL * height;
}
```
