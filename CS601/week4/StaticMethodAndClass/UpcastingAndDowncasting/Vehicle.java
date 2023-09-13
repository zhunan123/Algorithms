package week4.StaticMethodAndClass.UpcastingAndDowncasting;

public class Vehicle {
    private int numDoors;
    private int numSeats;
    private String vin;
    private String make;

    public int getNumDoors() {
        return numDoors;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public String getVin() {
        return vin;
    }

    public String getMake() {
        return make;
    }

    public Vehicle(int numDoors, int numSeats, String vin, String make) {
        this.numDoors = numDoors;
        this.numSeats = numSeats;
        this.vin = vin;
        this.make = make;
    }

    public String toString() {
        return numDoors + numSeats + vin + make;
    }
}
