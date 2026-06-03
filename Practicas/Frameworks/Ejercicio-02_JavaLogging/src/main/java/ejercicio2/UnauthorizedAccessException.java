package ejercicio2;

public class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
    //tuve que hacer esta excepcion para que no me haga cambiar la firma del metodo
}
