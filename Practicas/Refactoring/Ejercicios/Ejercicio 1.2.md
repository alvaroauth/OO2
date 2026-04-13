# Enunciado 
> Al revisar el siguiente diseño inicial (Figura 1), se decidió realizar un cambio para evitar lo que se consideraba un mal olor. El diseño modificado se muestra en la Figura 2. Indique qué tipo de cambio se realizó y si lo considera apropiado. Justifique su respuesta.

![[Pasted image 20260330152338.png]]
# Explicacion
El bad smell de la figura uno es la envidia de atributos desde `Persona` hacia `Proyecto`, ya que intenta tomar una responsabilidad que implica tener conocimiento de todas las personas que participan en el proyecto, conocimiento el cual solo tiene `Proyecto`, por lo cual persona debe pedirle la clase entera para calcular algo
### Cambios
- **Move Method:** Se mueve el metodo `participa` a Proyecto, asi `Persona` no tiene que pedirle la clase entera para calcularlo
### Falta
- Declarar el ID de persona como privado
- Declarar la lista `participantes` como privada y no exponerla con getters