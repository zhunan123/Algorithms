package week3.designPattern.immutability;

import java.util.Date;

public final class Plant {
    // Final primitive data is always immutable like String and Double, Integer
    private final double mass;
    private final String name;
    private final Date fDateOfDiscovery; // Date is mutable

    public Plant(double mass, String name, Date fDateOfDiscovery) {
        this.mass = mass;
        this.name = name;
        this.fDateOfDiscovery = new Date(fDateOfDiscovery.getTime()); // since Date is mutable so need to make copy of Date object
    }

    public double getMass() { // this is ok since mass is immutable
        return mass;
    }

    public String getName() { // this is ok since name is immutable
        return name;
    }

    public Date getDateOfDiscoveryBad() { // this is not ok since Date is mutable - no good
        return fDateOfDiscovery;
    }

    // need to make this return copy to make original list immutable
    public Date getDateOfDiscoveryGood() {
        return new Date(fDateOfDiscovery.getTime());
    }
}
