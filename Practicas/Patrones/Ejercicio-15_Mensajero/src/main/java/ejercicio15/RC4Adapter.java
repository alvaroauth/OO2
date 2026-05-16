package ejercicio15;

public class RC4Adapter implements Algoritmo {
    private RC4 encriptador = new RC4();
    private String key;

    public RC4Adapter(String key) {
        this.key = key;
        encriptador = new RC4();
    }

    @Override
    public String cifrar(String mensaje) {
        return encriptador.encriptar(mensaje, key);
    }

    @Override
    public String descifrar(String mensaje) {
        return encriptador.desencriptar(mensaje, key);
    }
}
