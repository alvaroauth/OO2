package ejercicio19;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModificacionDecorador extends VistaDecorador{
    protected ModificacionDecorador(FileOO2 archivo, VistaArchivo wrapped) {
        super(archivo, wrapped);
    }

    @Override
    protected String aspect() {
        LocalDate fecha = this.getArchivo().getModificacion();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(formato);
    }
}