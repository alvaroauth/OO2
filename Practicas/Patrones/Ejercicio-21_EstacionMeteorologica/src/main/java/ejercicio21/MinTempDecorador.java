package ejercicio21;

public class MinTempDecorador extends WeatherDecorador{
    public MinTempDecorador(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    protected String agregado() {
        return "Minimo: " + (this.getTemperaturas().stream().mapToDouble(t -> t).min().orElse(0.0));
    }
}