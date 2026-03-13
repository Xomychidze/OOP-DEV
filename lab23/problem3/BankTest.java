package lab23.problem3;


import java.util.Vector;

class Account {
    private double balance;
    private int accNumber;

    public Account(int accNumber) {
        this.balance = 0.0;
        this.accNumber = accNumber;
    }

    public void deposit(double sum) {
        if (sum > 0) balance += sum;
    }

    public void withdraw(double sum) {
        if (sum > 0 && sum <= balance) balance -= sum;
        else System.out.println("  ❌ Insufficient funds or invalid amount.");
    }

    public double getBalance() { return balance; }
    public int getAccountNumber() { return accNumber; }

    public void transfer(double amount, Account other) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            other.deposit(amount);
        } else {
            System.out.println("  ❌ Transfer failed.");
        }
    }

    @Override
    public String toString() {
        return String.format("Account #%d | Balance: $%.2f", accNumber, balance);
    }

    public final void print() {
        System.out.println(toString());
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accNumber, double interestRate) {
        super(accNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() { return interestRate; }

    public void addInterest() {
        double interest = getBalance() * (interestRate / 100.0);
        deposit(interest);
    }

    @Override
    public String toString() {
        return String.format("SavingsAccount #%d | Balance: $%.2f | Interest Rate: %.1f%%",
                getAccountNumber(), getBalance(), interestRate);
    }
}

class CheckingAccount extends Account {
    private static final int FREE_TRANSACTIONS = 3;
    private static final double FEE_PER_TRANSACTION = 0.02;
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

    public void deductFee() {
        int chargeableTransactions = Math.max(0, transactionCount - FREE_TRANSACTIONS);
        double fee = chargeableTransactions * FEE_PER_TRANSACTION;
        if (fee > 0) {
            System.out.printf("  💸 Fee deducted: $%.2f (%d extra transactions)%n",
                    fee, chargeableTransactions);
            super.withdraw(fee);
        }
        transactionCount = 0;
    }

    public int getTransactionCount() { return transactionCount; }

    @Override
    public String toString() {
        return String.format("CheckingAccount #%d | Balance: $%.2f | Transactions: %d (free: %d)",
                getAccountNumber(), getBalance(), transactionCount, FREE_TRANSACTIONS);
    }
}

class Bank {
    private Vector<Account> accounts = new Vector<>();

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("✅ Opened: " + account);
    }

    public void closeAccount(int accNumber) {
        accounts.removeIf(a -> a.getAccountNumber() == accNumber);
        System.out.println("🔒 Closed account #" + accNumber);
    }

    public Account findAccount(int accNumber) {
        for (Account a : accounts)
            if (a.getAccountNumber() == accNumber) return a;
        return null;
    }

    public void update() {
        System.out.println("\n📊 Running bank update...");
        for (Account a : accounts) {
            if (a instanceof SavingsAccount) {
                ((SavingsAccount) a).addInterest();
                System.out.println("  💰 Interest added → " + a);
            } else if (a instanceof CheckingAccount) {
                ((CheckingAccount) a).deductFee();
                System.out.println("  🏦 Fees processed → " + a);
            }
        }
    }

    public void printAll() {
        System.out.println("\n═══════════════ Bank Accounts ═══════════════");
        for (Account a : accounts) a.print();
        System.out.println("═════════════════════════════════════════════");
    }
}

public class BankTest {
    public static void main(String[] args) {

        Bank bank = new Bank();

        SavingsAccount savings1 = new SavingsAccount(1001, 5.0);
        SavingsAccount savings2 = new SavingsAccount(1002, 3.5);
        CheckingAccount checking1 = new CheckingAccount(2001);
        CheckingAccount checking2 = new CheckingAccount(2002);

        bank.openAccount(savings1);
        bank.openAccount(savings2);
        bank.openAccount(checking1);
        bank.openAccount(checking2);

        System.out.println("\n--- Savings Transactions ---");
        savings1.deposit(1000);
        savings2.deposit(500);

        System.out.println("\n--- Checking Transactions ---");
        checking1.deposit(200);
        checking1.deposit(100);
        checking1.withdraw(50);
        checking1.withdraw(30);
        checking1.deposit(80);

        checking2.deposit(300);
        checking2.withdraw(50);

        System.out.println("\n--- Transfer ---");
        savings1.transfer(200, savings2);
        System.out.println("  Transferred $200 from savings1 to savings2");

        bank.printAll();

        bank.update();

        bank.printAll();

        System.out.println();
        bank.closeAccount(1002);
        bank.printAll();
    }
}
