package seminars.fourth.weather;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherReporterTest {
    private static WeatherReporter weatherReporter;
    private static WeatherService weatherService;

    @BeforeAll
    public static void init(){
        weatherService = mock(WeatherService.class);
        when(weatherService.getCurrentTemperature()).thenReturn(22);
        weatherReporter = new WeatherReporter(weatherService);
    }

    @Test
    public void generateReportPositive(){
        assertTrue(weatherReporter.generateReport().contains("22"));
    }


}