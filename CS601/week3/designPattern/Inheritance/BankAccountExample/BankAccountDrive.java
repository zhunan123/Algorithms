package week3.designPattern.Inheritance.BankAccountExample;

public class BankAccountDrive {

    public static void main(String[] args) {
        SavingsAccount sv = new SavingsAccount("Hilary", 100.0, 1099, 0.5);
        sv.deposit(100);
        sv.withdraw(10);

        System.out.println(sv.getBalance()); // calling the method inherited from the parent
        sv.updateBalanceWithYearlyInterest(); // calling the method in the child
        System.out.println(sv.getBalance());
        System.out.println(sv); // Java will all toString method of the child


        BankAccount ba = new BankAccount("Stephanie", 100, 90);
    }
}
