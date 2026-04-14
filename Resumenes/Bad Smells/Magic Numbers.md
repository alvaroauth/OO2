Este bad smell pasa cuando en el codigo se usan numeros literales en el codigo sin explicar el porque estan ahi o que significan. Por ejemplo si a un cliente siempre se le descuenta el 21% del sueldo y esto lo hace un metodo, no estaria bueno poner diracemtente en ese metodo el valor 0.21.
### Ejemplos

```java
double calcularSueldoReal(double sueldoBruto){
	return sueldoBruto - (sueldoBruto * 0.21);
}
```
>El magic number seria el 0.21, que es el estandar de la empresa de cuanto se descuenta de un sueldo

```java
double energiaPotencial(double mass, double height){
	return mass * 9.81 * height;	
}
```
> El magic number seria el 9.81, que equivale a la constante gravitacional de la tierra
##### El problema de estos numeros es que no son autoexplicativos
### Refactoring
* [[Replace Magic Numbers with Symbolic Constant]]
