Es un refactoring que consiste en sustituir las estructuras de iteracion clasicas por una serie de operaciones declarativas en cadena (streams en java, linq en c#). 
Aplicando esto se logra pasar de una forma mecanica y extensa de recorrer algo a expresar de manera directa lo que se busca con los datos, resultando en un **codigo mas corto y expresivo**.
#### Codigo anterior
```java
public List<String> obtenerNombresActivos(List<Empleado> empleados) {
    List<String> nombresActivos = new ArrayList<>();
    for (int i = 0; i < empleados.size(); i++) {
        Empleado emp = empleados.get(i);
        if (emp.isActive()) {
            nombresActivos.add(emp.getName());
        }
    }
    return nombresActivos;
}
```

#### Codigo despues de aplicar el refactoring
```java
public List<String> obtenerNombresActivos(List<Empleado> empleados) {
    return empleados.stream()
                    .filter(e -> e.isActive)
                    .map(e -> e.getName)
                    .collect(Collectors.toList());
}
```

Despues de esto, hay que chequear que compile y los test devuelvan los mismos resultados