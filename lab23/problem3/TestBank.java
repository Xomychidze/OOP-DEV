public class TestBank {
    public static void main(String[] args) {
        Bank bank = new Bank("KBTU Bank");

        SavingsAccount savings1 = new SavingsAccount(1001, 5.0);
        SavingsAccount savings2 = new SavingsAccount(1002, 3.5);
        CheckingAccount checking1 = new CheckingAccount(2001);
        CheckingAccount checking2 = new CheckingAccount(2002);

        bank.openAccount(savings1);
        bank.openAccount(savings2);
        bank.openAccount(checking1);
        bank.openAccount(checking2);

        System.out.println("\n--- Performing transactions ---");
        savings1.deposit(1000.00);
        savings2.deposit(5000.00);

        checking1.deposit(200.00);
        checking1.withdraw(50.00);
        checking1.deposit(100.00);
        checking1.withdraw(30.00);  // 4th transaction, exceeds free limit

        checking2.deposit(500.00);
        checking2.withdraw(100.00);

        bank.printAll();
        bank.update();
        bank.printAll();

        System.out.println("--- Closing account #1002 ---");
        bank.closeAccount(1002);
        bank.printAll();

        System.out.println("--- Transfer from savings1 to checking1 ---");
        savings1.transfer(200.00, checking1);
        bank.printAll();
    }
}
