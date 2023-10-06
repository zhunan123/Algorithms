package week1.dataStructures;

public class BankAccount implements Comparable<BankAccount>{
    // Instance variables:
    private double balance;
    private String owner;

    public BankAccount(double balance, String owner) {
        this.balance = balance;
        this.owner = owner;
    }


    public double getBalance() {
        return this.balance;
    }


    public void deposit(double amount) {
        this.balance += amount;
    }


    public void withdraw(double amount) {
        if (this.balance - amount < 0) {
            throw new IllegalArgumentException();
        }
        this.balance = this.balance - amount;
    }


    public String toString() {

        return owner + ",  " + balance;
    }

    public int compareTo(BankAccount other) {
        if (this.balance < other.balance)
            return -1;
        else if (this.balance > other.balance)
            return 1;
        else
            return 0;
        //string-    return this.owner.compareTo(other.owner);
    }

}
