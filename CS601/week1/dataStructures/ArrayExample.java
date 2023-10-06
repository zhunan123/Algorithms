package week1.dataStructures;

import java.util.Arrays;

public class ArrayExample {
    public static void createIntArray() {
        int[] arr; // declare the array arr
        arr = new int[3]; // allocate memory
        arr[0] = 5;
        arr[1] = 3;
        arr[2] = 1;

        // Iterate using indices
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        // Iterate using a for each loop
        for (int elem: arr)
            System.out.println(elem);


        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void createBankAccountArray() {
        BankAccount[] accounts = {new BankAccount(300, "Smith"), new BankAccount(250, "Jones")};

        for (BankAccount account: accounts) {
            System.out.println(account);
        }

    }

    public static void main(String[] args) {
        createIntArray();
        //createBankAccountArray();
    }
}
