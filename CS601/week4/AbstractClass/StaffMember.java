package week4.AbstractClass;

public abstract class StaffMember {
    private String name;
    private String address;
    private String phone;

    public StaffMember(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "StaffMember{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }

    public abstract double pay();
}
