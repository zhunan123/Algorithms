package week6.mvc.simpleExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StudentDataModel implements Model{

    private Map<String, Student> studentMap = new TreeMap<>();
    private List<Observer> observerList = new ArrayList<>();

    public void addStudent(Student s) {
        studentMap.put(s.getName(), s);
    }
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o: observerList) {
            o.update();
        }
    }

    @Override
    public void changeName(String name1, String name2) {
        Student s1 = studentMap.get(name1);
        if (s1 != null) {
            s1.setName(name2);
            studentMap.remove(name1);
            studentMap.put(name2, s1);
            notifyObservers();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String stName: studentMap.keySet()) {
            sb.append(studentMap.get(stName));
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
