package parcialPaquetes;

public class Paquete implements Componente{
    private String descripcion;
    private String destinatario;
    private String direccionDestino;
    private double valorDeclarado;

    public Paquete(String desc, String dest, String dir, double v){
        descripcion = desc;
        destinatario = dest;
        direccionDestino = dir;
        valorDeclarado = v;
    }

    @Override
    public String getDescripcion() {
        return this.descripcion;
    }

    @Override
    public String getDestinatario() {
        return this.destinatario;
    }

    @Override
    public String getDireccionDestino() {
        return this.direccionDestino;
    }

    @Override
    public double getValorDeclarado() {
        return this.valorDeclarado;
    }

    @Override
    public double getCostoEnvio() {
        return this.valorDeclarado * 0.05;
    }
}
