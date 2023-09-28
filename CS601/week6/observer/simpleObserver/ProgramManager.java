package week6.observer.simpleObserver;

public class ProgramManager implements Observer {

    private String name;
    private String University;

    public ProgramManager(String name, String university) {
        this.name = name;
        University = university;
    }


    @Override
    public void update(String jobDescription) {
        if (jobDescription.contains("software development") || jobDescription.contains("software engineering")) {
            // send the mailing list
            System.out.println(name + ": Post to the student mailing list");
        }
    }
}
