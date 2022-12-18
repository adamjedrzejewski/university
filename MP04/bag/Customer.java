package bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private String firstName;
    private String lastName;

    private List<Account> accounts = new ArrayList<>();

    public Customer(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
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

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        if (!accounts.contains(account)) {
            throw new IllegalArgumentException("This account doesn't belong to this customer");
        }

        accounts.remove(account);
    }
}
