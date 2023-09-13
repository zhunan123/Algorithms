package week4.AbstractClass;

public class Fulltime extends Employee{

    private double bonus;

    public Fulltime(String name, String address, String phone, String socialSecurityNumber1, double payRate1) {
        super(name, address, phone, socialSecurityNumber1, payRate1);
        bonus = 0; // bonus has not yet to be rewarded
    }

    public void addBonus(double fulltimeBonus) {
        bonus = fulltimeBonus;
    }

    @Override
    public double pay() {
        // 2 method from child class to get parent class member variables
        // super.pay() or super.getPayRate() or getPayRate()
        // Question: when we call super.pay() we are getting this class's pay or parent's pay?
            // -> seems like we are adding current class's pay using super.pay()
            // -> i guess since no parent class, so we are getting this class's payrate? let me add a Employee class
        double payment = super.pay() + bonus; // so my question is super.pay() or super.getPayRate() is getting parent pay data or child pay data
        double payment1 = super.getPayRate() + bonus;
        double payment2 = getPayRate() + bonus;

        return payment;
    }
}
