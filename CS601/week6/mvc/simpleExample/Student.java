package week6.mvc.simpleExample;

public class Student {

    private String name;
    private double GPA;
    private int id;

    public Student(String name, double GPA, int id) {
        this.name = name;
        this.GPA = GPA;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGPA() {
        return GPA;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name  + ", " + id + ", " + GPA;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        Student s = (Student) obj;
        if (this.name.equals(s.name) && this.getGPA() == s.getGPA() && this.id == s.id) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (33*33*id + 33*name.hashCode() + GPA);
    }

}
