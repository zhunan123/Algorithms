package week3.designPattern.Inheritance.BankAccountExample;

public class BankAccount {
    private String name;
    private double balance;
    private long number;

    private String owner;

    public BankAccount(String name, double balance, long number) {
        this.name = name;
        this.balance = balance;
        this.number = number;
    }

    public BankAccount(String owner, double balance) { // second constructor
        this.balance = balance;
        this.owner = owner;
    }

    public void withdraw(double amount) {
        if (balance - amount >= 0) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("invalid withdraw amount");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
            "name='" + name + '\'' +
            ", balance=" + balance +
            ", number=" + number +
            '}';
    }
}
