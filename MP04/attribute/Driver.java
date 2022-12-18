package attribute;

public class Driver {
    private String licenseId;
    private String firstName;
    private String lastName;
    private int age;
    private int accidents;

    public Driver(String licenseId, String firstName, String lastName, int age) {
        setAge(age);
        setFirstName(firstName);
        setLastName(lastName);
        setLicenseId(licenseId);
    }

    public void setAccidents(int accidents) {
        if (accidents < 0) {
            throw new IllegalArgumentException("Accident can't be negative");
        }
        this.accidents = accidents;
    }

    public boolean isEligibleForDiscount() {
        return accidents == 0;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        if (licenseId == null) {
            throw new IllegalArgumentException("License Id can't be null.");
        }
        this.licenseId = licenseId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new IllegalArgumentException("First name can't be null.");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException("Last name can't be null.");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Driver age must be greater or equal to 18.");
        }
        this.age = age;
    }
}
