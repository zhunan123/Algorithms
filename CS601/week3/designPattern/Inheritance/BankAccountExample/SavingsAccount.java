package week3.designPattern.Inheritance.BankAccountExample;

public class SavingsAccount extends BankAccount{

    private double interestRate;

    public SavingsAccount(String name, double balance, long number, double interestRate) {
        super(name, balance, number);
        this.interestRate = interestRate;
    }

    public void updateBalanceWithYearlyInterest() {
        double currentBalance = getBalance();
        setBalance(currentBalance + currentBalance * interestRate / 100);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
            super.toString() +
            "interestRate=" + interestRate +
            '}';
    }
}
