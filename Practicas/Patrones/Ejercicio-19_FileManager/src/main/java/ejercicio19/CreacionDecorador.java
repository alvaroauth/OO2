package ejercicio19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreacionDecorador extends Decorador {
    public CreacionDecorador(ComponenteArchivo componente) {
        super(componente);
    }

    public String prettyPrint() {
        LocalDate fecha = this.getCreacion();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.componente.prettyPrint() + " - " + fecha.format(formato);
    }
}
