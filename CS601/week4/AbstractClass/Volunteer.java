package week4.AbstractClass;

public abstract class Volunteer extends StaffMember{
    public Volunteer(String vName, String vAddress, String vPhone) {
        super(vName, vAddress, vPhone);
    }

    //you can actually implement the abstract method
//    public double pay(){
//        return 1.00;
//    };

    // or we can keep this method abstract and make the class abstract, and let child class implement this method
    public abstract double pay();
}
