public class SavingsAccount extends Account {
    private double interestRate; // as a percentage, e.g. 3.5 means 3.5%

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }
    public void setInterestRate(double interestRate) { this.interestRate = interestRate; }

    // Adds accumulated interest to the balance
    public void addInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
        System.out.printf("Interest of $%.2f (%.1f%%) added to account #%d%n",
                interest, interestRate, getAccountNumber());
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount #%d | Balance: $%.2f | Interest Rate: %.1f%%",
                getAccountNumber(), getBalance(), interestRate);
    }
}
