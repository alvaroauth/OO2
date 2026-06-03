package ejercicio19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModificacionDecorador extends Decorador {
    public ModificacionDecorador(ComponenteArchivo componente) {
        super(componente);
    }

    public String prettyPrint() {
        LocalDate fecha = this.getModificacion();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.componente.prettyPrint() + " - " + fecha.format(formato);
    }
}