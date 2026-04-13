![[Pasted image 20260411174701.png]]

1. Indique el mal olor.
2. Indique el refactoring que lo corrige.
3. Aplique el refactoring, mostrando el resultado final (código y/o diseño según corresponda). 

Si vuelve a encontrar un mal olor, retorne al paso (i)

```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }

   // ordena los posts por fecha
   for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
       int masNuevo = i;
       for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
           if (postsOtrosUsuarios.get(j).getFecha().isAfter(
     postsOtrosUsuarios.get(masNuevo).getFecha())) {
              masNuevo = j;
           }    
       }
      Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
      postsOtrosUsuarios.set(masNuevo, unPost);    
   }
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() &&  index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```

### Bad Smells
- Imperative Loops: El codigo tiene un monton de bucles for e iteradores para recorrer una lista
	- Se manejan manualmente inicializaciones, las paradas y el avance de los iteradores y genera que la verdadera intencion del codigo se vea opacada por esto
- Long Method: El metodo es muy largo y dificil de entender
	- Intenta filtrar los objetos, implementar manualmente un algoritmo de ordenacion y crear la lista resultado
- Comments: El codigo necesita de comentarios ya que no es autoexplicativo
	- Revela un codigo mal escrito o complejo, que no se entiende por si solo
### Refactoring
- **Replace Loop with Pipeline:** Esto soluciona los 3 bad smells a la vez ya que genera un codigo mas limpio y no opacado por los bucles imperativos. A su vez, reduce la cantidad de lineas significativamente, pudiendo hacer todo en una sola consulta.

```java
public List<Post> ultimosPosts(Usuario user, int cantidad){
	return posts.stream()
	.filter(p -> !p.getUser().equals(user))
	.sorted(Comparator.comparing(p -> p.getFecha()), Comparator.reverseOrder())
	.limit(cantidad);
}
```
