package bag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bank {
    private String bankCode;

    private List<Account> accounts = new ArrayList<>();

    public Bank(String bankCode) {
        setBankCode(bankCode);
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        if (bankCode == null) {
            throw new IllegalArgumentException("Last name can't be null.");
        }
        this.bankCode = bankCode;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        if (!accounts.contains(account)) {
            throw new IllegalArgumentException("This account doesn't belong to this bank");
        }

        accounts.remove(account);
    }
}
