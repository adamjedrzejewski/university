public class Driver {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    private TruckDriver truckDriver;

    public Driver(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TruckDriver getTruckDriver() {
        return truckDriver;
    }

    public void setTruckDriver(TruckDriver truckDriver) {
        if (this.truckDriver != null) {
            return;
        }

        this.truckDriver = truckDriver;
        this.truckDriver.setDriver(this);
    }

    public void removeTruckDriver() {
        if (this.truckDriver == null) {
            return;
        }

        this.truckDriver.removeLinks();
        this.truckDriver = null;
    }

    public Truck getTruck() {
        return this.truckDriver.getTruck();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
