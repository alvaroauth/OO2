package ejercicio21;

import java.util.Arrays;
import java.util.List;

public class HomeWeatherStation implements WeatherData{

    // Por lo q entendi hay q mockear los valores, pero no se

    public double getTemperatura() {
        return 86.0; // 86°F = 30°C
    }

    public double getPresion() {
        return 1008;
    }

    public double getRadiacionSolar() {
        return 200;
    }

    public List<Double> getTemperaturas() {
        // En Fahrenheit. Equivalencias en Celsius: 27, 30, 32, 31
        // Min = 80.6 (27°C), Max = 89.6 (32°C), Promedio = 86 (30°C)
        return Arrays.asList(80.6, 86.0, 89.6, 87.8);
    }

    @Override
    public String displayData() {
        return "Temperatura F: " + this.getTemperatura() +
                "Presión atmosf: " + this.getPresion() +
                "Radiación solar: " + this.getRadiacionSolar();
    }
}
