package week4.AbstractClass;

public class HourlyContractor extends Employee{

    private int hourWorked;

    public HourlyContractor(String name, String address, String phone, String socialSecurityNumber1, double payRate1) {
        super(name, address, phone, socialSecurityNumber1, payRate1);
        hourWorked = 0;
    }

    public void addHours(int hour) {
        hourWorked += hour;
    }

    @Override
    public double pay() {
        double payment = hourWorked * super.getPayRate(); // this super.getPayRate() will return current contractor's payRate but extends this getPayRate() method from parent class
        return payment;
    }
}
