package ejercicio21;

public class MaxTempDecorador extends WeatherDecorador{
    public MaxTempDecorador(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    protected String agregado() {
        return "Maximo: " + (this.getTemperaturas().stream().mapToDouble(t -> t).max().orElse(0.0));
    }
}
