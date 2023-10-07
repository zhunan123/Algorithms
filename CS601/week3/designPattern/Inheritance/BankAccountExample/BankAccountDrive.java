package week3.designPattern.Inheritance.BankAccountExample;

public class BankAccountDrive {

    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("jack", 100.0, 1099, 0.5);

        account.deposit(100);
        account.updateBalanceWithYearlyInterest();

    }
}
