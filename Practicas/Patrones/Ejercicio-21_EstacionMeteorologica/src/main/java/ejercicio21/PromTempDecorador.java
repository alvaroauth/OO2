package ejercicio21;

public class PromTempDecorador extends WeatherDecorador{
    public PromTempDecorador(WeatherData wrapped) {
        super(wrapped);
    }

    @Override
    protected String agregado() {
        return "Promedio: " + (this.getTemperaturas().stream().mapToDouble(t -> t).average().orElse(0.0));
    }
}