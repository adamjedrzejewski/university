
package disjoint;

import java.util.*;

public class Manager extends Employee {

    private List<Employee> subordinates = new ArrayList<>();

    public Manager(String firstName, String lastName, String employeeId, double salary) {
        super(firstName, lastName, employeeId, salary);
    }

    public List<Employee> getSubordinates() {
        return new ArrayList<>(this.subordinates);
    }

    public boolean addSubordinate(Employee employee) {
        return this.subordinates.add(employee);
    }
}