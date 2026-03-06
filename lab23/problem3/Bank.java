import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new Vector<>();
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened: " + account);
    }

    public boolean closeAccount(int accNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accNumber) {
                accounts.remove(acc);
                System.out.println("Account #" + accNumber + " closed.");
                return true;
            }
        }
        System.out.println("Account #" + accNumber + " not found.");
        return false;
    }

    // update: adds interest to SavingsAccounts and deducts fees from CheckingAccounts
    public void update() {
        System.out.println("\n--- Bank Update ---");
        for (Account acc : accounts) {
            if (acc instanceof SavingsAccount) {
                ((SavingsAccount) acc).addInterest();
            } else if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFee();
            }
        }
        System.out.println("--- Update Done ---\n");
    }

    public void printAll() {
        System.out.println("\n=== " + bankName + " Accounts ===");
        for (Account acc : accounts) {
            acc.print();
        }
        System.out.println();
    }
}
