package week6.observer.weather;

public class Driver {

    public static void main(String[] args) {
        // subject is always called model or observables

        WeatherDataModel model = new WeatherDataModel();

        // register 3 observer which is the weather display that listens to model
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(model);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(model);
        ForecastDisplay forecastDisplay = new ForecastDisplay(model);


        // set measurements to give model weather data that can be delivered to weather display
        model.setMeasurements(80, 65, 30.4f);
        System.out.println();
        model.setMeasurements(82, 70, 29.2f);
        System.out.println();
    }
}
