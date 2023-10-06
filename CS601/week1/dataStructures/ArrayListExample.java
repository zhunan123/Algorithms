package week1.dataStructures;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("China");
        countries.add("Italy");

        for (int i = 0; i < countries.size(); i++) {
            System.out.print(countries.get(i) + " ");
        }

        for (String country: countries) {
            System.out.println(country);
        }

        Collections.sort(countries);
        System.out.println(countries);

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(200, "jack"));
        accounts.add(new BankAccount(300, "backy"));

        Collections.sort(accounts);
        System.out.println(accounts);
    }
}
