package week6.mvc.simpleExample;

public class StudentController implements  Controller{

    private Model model;

    public StudentController(Model model) {
        this.model = model;
    }

    @Override
    public void changeStudentName(String name1, String name2) {
        if (!name1.isEmpty() && !name2.isEmpty() && (!name1.equals(name2))) {
            // will call model changeName method to change name
            // can also preform other validation checks
            model.changeName(name1, name2);
        }
    }
}
