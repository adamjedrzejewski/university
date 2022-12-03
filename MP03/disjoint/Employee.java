package disjoint;

public class Employee {

    private double salary;
    private String firstName;
    private String lastName;
    private String employeeId;

    protected Employee(String firstName, String lastName, String employeeId, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmployeeId(employeeId);
        setSalary(salary);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }

        this.lastName = lastName;
    }

    public void setEmployeeId(String employeeId) {
        if (employeeId == null || employeeId.isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty");
        }

        this.employeeId = employeeId;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }

        this.salary = salary;
    }
}