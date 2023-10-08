package week3.designPattern.Inheritance.UpcastingAndDowncasting;

public class Truck extends Vehicle{
    private boolean isPickup;

    public Truck(int numDoors, int numSeats, String vin, String make, boolean isPickup) {
        super(numDoors, numSeats, vin, make);
        this.isPickup = isPickup;
    }

    public static void say() {
        System.out.println("hello");
    }
    public String toString() {
        return getNumDoors() + "," + getNumSeats() + "," + getVin() + "," + getMake() + "," + isPickup;
    }
}
