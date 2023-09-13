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

        System.out.println(staffs[0].pay());
    }
}
