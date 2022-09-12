public class School {
    private String schoolName;

    public static void main(String[] args){
        School sc = new School();
        sc.setName("University of San Francisco");
        sc.getName();
    }

    public void setName(String name){
        this.schoolName = name;
    }

    public String getName(){
        return schoolName;
    }
}
