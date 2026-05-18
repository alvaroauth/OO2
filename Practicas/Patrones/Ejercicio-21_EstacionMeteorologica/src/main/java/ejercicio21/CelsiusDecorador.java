package ejercicio21;
import java.util.List;
import java.util.stream.Collectors;

public class CelsiusDecorador extends WeatherDecorador {

    public CelsiusDecorador(WeatherData wrapped) {
        super(wrapped);
    }

    private double aCelsius(double f) {
        return (f - 32) / 1.8;
    }

    @Override
    public double getTemperatura() {
        return aCelsius(getWrapped().getTemperatura());
    }

    @Override
    public List<Double> getTemperaturas() {
        return getWrapped().getTemperaturas().stream()
                .map(this::aCelsius)
                .collect(Collectors.toList());
    }

    // La unica manera que encontre de hacerlo
    @Override
    public String displayData() {
        double f = getWrapped().getTemperatura();
        double c = this.getTemperatura();
        return getWrapped().displayData()
                .replace("Temperatura F: " + f, "Temperatura C: " + c);
    }

    @Override
    protected String agregado() {
        return "";
    }
}