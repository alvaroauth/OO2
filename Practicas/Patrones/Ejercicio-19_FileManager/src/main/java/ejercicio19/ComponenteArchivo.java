package ejercicio19;

import java.time.LocalDate;

public interface ComponenteArchivo {
    String prettyPrint();
    String getNombre();
    String getExtension();
    int getTamanio();
    LocalDate getCreacion();
    public LocalDate getModificacion();
    public String getPermisos();
}
