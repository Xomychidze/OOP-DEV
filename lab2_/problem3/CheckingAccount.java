public class CheckingAccount extends Account {
    private static final int FREE_TRANSACTIONS = 3;
    private static final double FEE_PER_EXTRA_TRANSACTION = 0.02;
    private int transactionCount;

    public CheckingAccount(int accNumber) {
        super(accNumber);
        this.transactionCount = 0;
    }

    @Override
    public void deposit(double sum) {
        super.deposit(sum);
        transactionCount++;
    }

    @Override
    public void withdraw(double sum) {
        super.withdraw(sum);
        transactionCount++;
    }

    public int getTransactionCount() { return transactionCount; }

    // Deducts $0.02 for each transaction beyond FREE_TRANSACTIONS
    public void deductFee() {
        if (transactionCount > FREE_TRANSACTIONS) {
            int extraTransactions = transactionCount - FREE_TRANSACTIONS;
            double fee = extraTransactions * FEE_PER_EXTRA_TRANSACTION;
            // Use super.withdraw to avoid counting fee deduction as a transaction
            super.withdraw(fee);
            System.out.printf("Fee of $%.2f deducted for %d extra transactions on account #%d%n",
                    fee, extraTransactions, getAccountNumber());
        } else {
            System.out.printf("No fee for account #%d (%d/%d free transactions used)%n",
                    getAccountNumber(), transactionCount, FREE_TRANSACTIONS);
        }
    }

    public void resetTransactionCount() {
        transactionCount = 0;
    }

    @Override
    public String toString() {
        return String.format("CheckingAccount #%d | Balance: $%.2f | Transactions: %d (free: %d)",
                getAccountNumber(), getBalance(), transactionCount, FREE_TRANSACTIONS);
    }
}
