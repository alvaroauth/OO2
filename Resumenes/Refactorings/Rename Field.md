Consiste en cambiar el nombre de un campo de una clase por otro. No lleva pasos extra debido a que el mismo autor del libro considera que es algo tan simple que no le da pasos extra al refactoring.

>Often the simplest and most important thing you can do is to change the name of a method.
Naming is a key tool in communication. If you understand what a program is doing, you should
not be afraid to use Rename Method to pass on that knowledge. You can (and should) also
rename variables and classes. On the whole these renamings are fairly simple text replacements,
so I haven't added extra refactorings for them.
**Extraido de Refactoring: Improving the Design of Existing Code**

### Ejemplo
```java
public class Auto{
	private String patente;
	//...
}
```
### Refactoring
```java
public class Auto{
	private String dominio;
	//...
}
```

> **Nota: Hay que buscar todas las apariciones del anterior nombre y reemplazarlos por el nuevo**

