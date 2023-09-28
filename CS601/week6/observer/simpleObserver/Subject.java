package week6.observer.simpleObserver;

public interface Subject {
    // model
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    String getInfo();
}
