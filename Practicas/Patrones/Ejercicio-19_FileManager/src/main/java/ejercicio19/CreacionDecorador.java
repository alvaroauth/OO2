package ejercicio19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreacionDecorador extends VistaDecorador{
    public CreacionDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        LocalDate fecha = this.getArchivo().getCreacion();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formato);
    }
}
