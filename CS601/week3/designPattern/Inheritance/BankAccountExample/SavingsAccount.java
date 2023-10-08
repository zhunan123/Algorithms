package week3.designPattern.Inheritance.BankAccountExample;

public class SavingsAccount extends BankAccount {
    private double interestRate; // yearly interest rate
    // should not have name variable as parent class, it can but not good design confusing and unnecessary

    public SavingsAccount(String name, double balance, long number, double interestRate) {
        // cannot do this.name = name since name is private and not able to access it
        // so we use super, it calls the parents constructor
        super(name, balance, number);
        this.interestRate = interestRate;

    }

    public void updateBalanceWithYearlyInterest() {
        double currBalance  = getBalance();
        setBalance(currBalance + currBalance * interestRate / 100.0);

    }

    @Override
    public String toString() {
        return super.toString() + ", interest rate: " + interestRate;
    }
    //return super.toString() will call name and balance and number
    // if we dont want suer.toString() we can just call getName() and getBalance() in bankAccount class, child still ablt to access parent method
}
