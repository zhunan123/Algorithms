package week6.observer.simpleObserver;

public class Driver {

    public static void main(String[] args) {
        Subject company = new Company("Vrbo"); //model, this company has the interface type. need to downcast it after

        Observer o1 = new Student("Aarthi P."); // observer
        Observer o2 = new Student("Tracy L.");
        Observer o3 = new Student("Hao C.");

        // observer/student registered/subscribed
        company.registerObserver(o1);
        company.registerObserver(o2);
        company.registerObserver(o3);

        // university program manager registered
        Observer o4 = new ProgramManager("Jim Harry", "USF");
        company.registerObserver(o4);

        //company has type of subject need to downcast the company type
        ((Company)company).addInternship("Looking for software engineering intern with ReactJs");
        ((Company)company).addInternship("Looking for software development intern with nodeJs");
        ((Company)company).addInternship("Looking for music intern with other music skills");


    }
}
