package week4.AbstractClass;

public class Employee extends StaffMember{
    private String socialSecurityNumber;
    private double payRate;

    public Employee(String name, String address, String phone, String socialSecurityNumber1, double payRate1) {
        super(name, address, phone);
        this.socialSecurityNumber = socialSecurityNumber1;
        this.payRate = payRate1;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public double getPayRate() {
        return payRate;
    }

    @Override
    public double pay() {
        return payRate;
    }
}
