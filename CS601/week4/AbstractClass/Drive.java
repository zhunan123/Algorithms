package week4.AbstractClass;

public class Drive {

    public static void main(String[] args) {
        StaffMember[] staffs = new StaffMember[3];
        staffs[0] = new Fulltime("jack", "123 main", "3342-33", "123-34-55", 3333.33);
        staffs[1] = new HourlyContractor("mary", "123 main", "3342-33", "123-34-55", 20.12);
        staffs[2] = new Employee("Woody", "789 Off Rocker", "555-0000", "010-20-3040", 1169.23);

        if (staffs[0] instanceof Fulltime) {
            ((Fulltime)staffs[0]).addBonus(500);
        }

        // vehicle v1 = new vehicle()
        // call back with the t2 = (Truck)v1 example which this downcasting will case a run time compiler error
        // v1 has type of Vehicle and point to a vehicle object, so cannot cast v1 to truck

        // see this case
        // staffs[0] has a type of StaffMember but it actually points to Fulltime object reference,
        // so we can do downcast  from staffMember to fullTime like this ((FullTime)staffs[0]).whateverFulltimeMethos() since staffs[0] actually points to a fullTime object

        System.out.println(staffs[0].pay()); //super.getPayRate() + bonus = 3333.33 + 500 = 3833.33
    }
}
