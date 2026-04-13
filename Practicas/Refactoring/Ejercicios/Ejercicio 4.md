>**Publicacion.java**
```java
public class Publicacion {
   private String texto;
   private int likes;

   public Publicacion(String texto) {
      this.texto = texto;
      this.likes = 0;
   }

   public void darLike() { likes++; }

   public void darDislike() { likes--; }
   
   private int procesar() {
       return likes * 3;
   }
   
   public int calcular() {
       return procesar() * 10;
   }
}
```

>**Perfil.java**
```java
public class Perfil {
   private boolean verificado;
   private ArrayList<Publicacion> publicaciones;

   public Perfil(boolean verificado) {
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
   }

   public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
   
   private int bonus() { return verificado ? 2 : 1; }

   private int alcanceDePublicaciones() {
       return publicaciones.stream().mapToInt(p -> p.calcular()).sum();
   }

   public int calcular() {
       return alcanceDePublicaciones() * bonus();
   }
}
```

---
### Ejercicio

==TODOS LOS RENAMES EN TEORIA SIGUEN EL PROTOCOLO DE CREAR EL METODO NUEVO, CAMBIAR LAS REFERENCIAS Y ELIMINAR EL VIEJO, NO LO HAGO ACA PORQUE NO ENTRA==

> 1. **Rename method: procesar (referenciado en línea 11 de Publicacion.java) por impacto**

Se cambiaria solo el archivo Publicacion y habria que cambiar las lineas 11 y 15, sustituyendo las apariciones de procesar por impacto
```java
public class Publicacion {
   private String texto;
   private int likes;

   public Publicacion(String texto) {
      this.texto = texto;
      this.likes = 0;
   }

   public void darLike() { likes++; }

   public void darDislike() { likes--; }
   
   private int impacto() {
       return likes * 3;
   }
   
   public int calcular() {
       return impacto() * 10;
   }
}
```

>2. **Rename method: calcular (referenciado en línea 14 de Publicacion.java) por alcance**

En el archivo de publicacion habria que cambiar solo la linea que define al metodo, mientras que en el archivo de Perfil habria que modificar el metodo `alcanceDePublicaciones` y sustuit procesar por alcance.
```java
public class Publicacion {
   private String texto;
   private int likes;

   public Publicacion(String texto) {
      this.texto = texto;
      this.likes = 0;
   }

   public void darLike() { likes++; }

   public void darDislike() { likes--; }
   
   private int procesar() {
       return likes * 3;
   }
   
   public int alcance() {
       return procesar() * 10;
   }
}
```

```java
public class Perfil {
   private boolean verificado;
   private ArrayList<Publicacion> publicaciones;

   public Perfil(boolean verificado) {
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
   }

   public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
   
   private int bonus() { return verificado ? 2 : 1; }

   private int alcanceDePublicaciones() {
       return publicaciones.stream().mapToInt(p -> p.alcance()).sum();
   }

   public int calcular() {
       return alcanceDePublicaciones() * bonus();
   }
}
```

>3. **Rename method: calcular (referenciado en línea 15 de Perfil.java) por alcance**

No habria que cambiar ninguna referencia externa, solo habria que modificar el nombre del metodo

```java
public class Perfil {
   private boolean verificado;
   private ArrayList<Publicacion> publicaciones;

   public Perfil(boolean verificado) {
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
   }

   public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
   
   private int bonus() { return verificado ? 2 : 1; }

   private int alcanceDePublicaciones() {
       return publicaciones.stream().mapToInt(p -> p.alcance()).sum();
   }

   public int alcance() {
       return alcanceDePublicaciones() * bonus();
   }
}
```

>4. **Rename parameter: el parámetro “p” del método agregarPublicacion (línea 10 de Perfil.java) por “publicacion”**

Solo habria que cambiar el nombre del parametro y la referencia en `publicaciones.add(p);` por `publicaciones.add(publicacion);` (No genera conflicto ya que la clase es con mayuscula )

```java
public class Perfil {
   private boolean verificado;
   private ArrayList<Publicacion> publicaciones;

   public Perfil(boolean verificado) {
        this.verificado = verificado;
        this.publicaciones = new ArrayList<>();
   }

   public void agregarPublicacion(Publicacion p) { publicaciones.add(p); }
   
   private int bonus() { return verificado ? 2 : 1; }

   private int alcanceDePublicaciones() {
       return publicaciones.stream().mapToInt(p -> p.alcance()).sum();
   }

   public int alcance() {
       return alcanceDePublicaciones() * bonus();
   }
}
```