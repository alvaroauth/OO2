package ejercicio2;

import java.util.List;

public class Usuario {
    private String nombre;
    private boolean autenticado;

    public Usuario(String nombre, boolean autenticado) {
        this.nombre = nombre;
        this.autenticado = autenticado;
    }

    public boolean estaAutenticado(){
        return autenticado;
    }
}
