package week6.observer.simpleObserver;

public class Student implements Observer{
    //  student is observer will subscribe to internshipList from the company/model
    private String name;
    public Student(String name) {
        this.name = name;
    }


    @Override
    public void update(String info) {
        System.out.println(name + ": reat! I will go apply for this internship now!");
        System.out.println(info);
    }
}
