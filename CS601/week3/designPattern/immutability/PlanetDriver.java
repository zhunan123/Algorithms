package week3.designPattern.immutability;

import java.util.Date;

public class PlanetDriver {
    public static void main(String[] args) {
        Plant p = new Plant(900.6, "MyPlanet", new Date());
        Date d = p.getDateOfDiscoveryGood();
        System.out.println(d);

        // here is modifing the date by adding 6 sec
        // but since getDateOfDiscoveryGood() is a copy of original date, date will not change
        d.setTime(6000);
        System.out.println(d);

        // original date will not change
        System.out.println(p.getDateOfDiscoveryGood());
    }
}
