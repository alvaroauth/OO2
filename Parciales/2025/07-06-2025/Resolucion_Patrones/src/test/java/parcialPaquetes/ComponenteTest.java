package parcialPaquetes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponenteTest {

    private Componente componente;

    @BeforeEach
    public void setUp(){
        componente = new SeguroDecorador(new EntregaExpresDecorador(new Paquete("Caja de libros", "Berisso", "Montevideo esq 13", 20000.0)));
    }

    @Test
    public void testCostoEntrega(){
        assertEquals(15000, componente.getCostoEnvio());
        assertEquals(20000, componente.getValorDeclarado());
    }

    @Test
    public void testDescripcion(){
        assertEquals("Caja de libros - envio express - con seguro", this.componente.getDescripcion());
    }
}