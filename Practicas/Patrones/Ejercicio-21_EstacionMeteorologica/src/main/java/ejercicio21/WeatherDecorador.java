package ejercicio21;

import java.util.List;

public abstract class WeatherDecorador implements WeatherData{
    private WeatherData wrapped;

    public WeatherDecorador(WeatherData wrapped) {
        this.wrapped = wrapped;
    }

    protected WeatherData getWrapped() { return wrapped; }

    @Override public double getTemperatura()      { return wrapped.getTemperatura(); }
    @Override public double getPresion()          { return wrapped.getPresion(); }
    @Override public double getRadiacionSolar()   { return wrapped.getRadiacionSolar(); }
    @Override public List<Double> getTemperaturas() { return wrapped.getTemperaturas(); }

    @Override
    public String displayData() {
        return wrapped.displayData() + " " + agregado();
    }

    protected abstract String agregado();
}
