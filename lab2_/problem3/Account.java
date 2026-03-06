public class Account {
    private double balance;
    private int accNumber;

    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        if (sum <= 0) throw new IllegalArgumentException("Deposit amount must be positive.");
        balance += sum;
    }

    public void withdraw(double sum) {
        if (sum <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive.");
        if (sum > balance) throw new IllegalArgumentException("Insufficient funds.");
        balance -= sum;
    }

    public double getBalance() { return balance; }
    public int getAccountNumber() { return accNumber; }

    public void transfer(double amount, Account other) {
        this.withdraw(amount);
        other.deposit(amount);
    }

    @Override
    public String toString() {
        return String.format("Account #%d | Balance: $%.2f", accNumber, balance);
    }

    public final void print() {
        System.out.println(toString());
    }
}
