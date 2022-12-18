package bag;

public class Account {
    private Customer customer;
    private Bank bank;
    private String accountId;
    private int balance;

    public Account(Customer customer, Bank bank, String accountId, int balance) {
        setAccountId(accountId);
        setBalance(balance);
        setBank(bank);
        setCustomer(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addToBalance(int value) {
        this.balance += value;
    }

    public void subtractFromBalance(int value) {
        this.balance -= value;
    }
}
