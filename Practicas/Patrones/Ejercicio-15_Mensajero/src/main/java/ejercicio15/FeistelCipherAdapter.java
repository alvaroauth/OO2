package ejercicio15;

public class FeistelCipherAdapter implements Algoritmo {
    private FeistelCipher encriptador;
    public FeistelCipherAdapter(String key) {
        encriptador = new FeistelCipher(key);
    }

    @Override
    public String cifrar(String mensaje) {
        return encriptador.encode(mensaje);
    }

    @Override
    public String descifrar(String mensaje) {
        return encriptador.encode(mensaje);
    }
}
