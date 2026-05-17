import ejercicio19.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VistaArchivoTest {

    private FileOO2 archivo;

    @BeforeEach
    public void setUp() {
        archivo = new FileOO2(
                "informe", "pdf", 2048L,
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2024, 8, 1),
                "rw-r--r--"
        );
    }

    @Test
    void nombreExtensionTest(){
        VistaArchivo vista = new NombreDecorador(archivo, new ExtensionDecorador(archivo, new VistaVacia()));
        assertEquals(vista.prettyPrint(), "informe - pdf");
    }

    @Test
    void nombreCreacionExtensionTest(){
        VistaArchivo vista = new NombreDecorador(archivo, new CreacionDecorador(archivo, new ExtensionDecorador(archivo, new VistaVacia())));
        assertEquals(vista.prettyPrint(), "informe - 15/03/2024 - pdf");
    }

    @Test
    void nombreTamanioPermisosExtensionTest(){
        VistaArchivo vista = new NombreDecorador(archivo, new TamanioDecorador(archivo, new PermisosDecorador(archivo, new ExtensionDecorador(archivo, new VistaVacia()))));
        assertEquals(vista.prettyPrint(), "informe - 2048 - rw-r--r-- - pdf");
    }
}
