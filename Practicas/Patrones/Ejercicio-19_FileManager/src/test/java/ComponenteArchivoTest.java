import ejercicio19.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponenteArchivoTest   {
    private FileOO2 archivo;

    @BeforeEach
    public void setUp() {
        archivo = new FileOO2(
                "informe", "pdf", 2048,
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2024, 8, 1),
                "rw-r--r--"
        );
    }

    @Test
    void nombreExtensionTest() {
        ComponenteArchivo vista = new ExtensionDecorador(archivo);
        assertEquals("informe - pdf", vista.prettyPrint());
    }

    @Test
    void nombreCreacionExtensionTest() {
        ComponenteArchivo vista =
                new ExtensionDecorador(new CreacionDecorador(archivo));
        assertEquals("informe - 15/03/2024 - pdf", vista.prettyPrint());
    }

    @Test
    void nombreTamanioPermisosExtensionTest() {
        ComponenteArchivo vista =
                new ExtensionDecorador(new PermisosDecorador(new TamanioDecorador(archivo)));
        assertEquals("informe - 2048 - rw-r--r-- - pdf", vista.prettyPrint());
    }
}