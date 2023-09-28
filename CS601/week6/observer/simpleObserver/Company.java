package week6.observer.simpleObserver;

import java.util.ArrayList;
import java.util.List;

public class Company implements Subject{

    // company is model/subject will notify the student

    private String name;
    private List<Observer> observerList;
    private List<String> internships;

    public Company(String name) {
        this.name = name;
        this.observerList = new ArrayList<>();
        this.internships = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observerList.indexOf(observer);
        if (index > 0) {
            observerList.remove(index);
        }
    }

    public void addInternship(String jobDescription) {
        internships.add(jobDescription);
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observerList){
            o.update(getInfo());
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(System.lineSeparator());
        for (String internship: internships) {
            sb.append(internship + System.lineSeparator());
        }
        return sb.toString();
    }

}
