package week6.observer.weather;

public interface Observer {
    void update(float temp, float humidity, float pressure);
}
