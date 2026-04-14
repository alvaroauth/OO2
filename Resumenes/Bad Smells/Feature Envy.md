Este bad smell pasa cuando **un metodo esta mas interesado en los datos y metodos de otra clase que en los de su propia clase**. 
El enfoque principal de la programacion orientada a objetos es empaquetar los datos junto con los procesos y comportamientos que actuan sobre ellos, por ejemplo cuando se invoca demasiado unn getter de otro objeto es un claro indicio de que el metodo esta ubicado en la clase equivocada

### Ejemplos

```java
public class CalculadoraDeEnvios {
    public double calcularCostoEnvio(Paquete paquete) {
        double peso = paquete.getPeso();
        double volumen = paquete.getAlto() * 
				        paquete.getAncho() * 
				        paquete.getProfundidad();
        
        if (peso > 10 || volumen > 100) {
            return 5000.0;
        } else {
            return 2500.0;
        }
    }
}
```

```java
public class GeneradorEtiquetas {

    public String generarEtiquetaImpresion(Cliente cliente) {
        return "Destinatario: " + cliente.getNombre() + " " + 
							      cliente.getApellido() + "\n" +
               "Dirección: " + cliente.getCalle() + " " + 
				               cliente.getAltura() + "\n" +
               "Localidad: " + cliente.getCiudad() + " (" + 
				               cliente.getCodigoPostal() + ")";
    }
}
```

### Refactorings
- [[Move Method]]
- [[Extract Method]] y luego [[Move Method]]
- [[Move Field]] (poco comun).