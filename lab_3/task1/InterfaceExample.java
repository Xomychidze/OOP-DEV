package task1;



// --- Interface ---
interface Payable {
    boolean pay(double amount);
    double getBalance();
}

interface Refundable {
    boolean refund(double amount);
}

// --- Unrelated class 1 ---
class CreditCard implements Payable, Refundable {
    private String cardNumber;
    private double balance;

    public CreditCard(String cardNumber, double balance) {
        this.cardNumber = cardNumber;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("CreditCard paid: $" + amount);
            return true;
        }
        System.out.println("CreditCard: insufficient funds.");
        return false;
    }

    @Override
    public double getBalance() { return balance; }

    @Override
    public boolean refund(double amount) {
        balance += amount;
        System.out.println("CreditCard refunded: $" + amount);
        return true;
    }
}

// --- Unrelated class 2 ---
class PayPalAccount implements Payable {
    private String email;
    private double balance;

    public PayPalAccount(String email, double balance) {
        this.email = email;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("PayPal (" + email + ") paid: $" + amount);
            return true;
        }
        System.out.println("PayPal: insufficient funds.");
        return false;
    }

    @Override
    public double getBalance() { return balance; }
}

// --- Unrelated class 3 ---
class CryptoWallet implements Payable, Refundable {
    private String address;
    private double balance;

    public CryptoWallet(String address, double balance) {
        this.address = address;
        this.balance = balance;
    }

    @Override
    public boolean pay(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Crypto wallet paid: $" + amount);
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() { return balance; }

    @Override
    public boolean refund(double amount) {
        balance += amount;
        System.out.println("Crypto refunded: $" + amount);
        return true;
    }
}

// --- Demo ---
public class InterfaceExample {
    // Method accepts ANY Payable — doesn't care about concrete class
    public static void checkout(Payable method, double price) {
        System.out.println("Balance before: $" + method.getBalance());
        method.pay(price);
        System.out.println("Balance after:  $" + method.getBalance());
        System.out.println();
    }

    public static void main(String[] args) {
        Payable card   = new CreditCard("1234-5678", 500.0);
        Payable paypal = new PayPalAccount("user@mail.com", 200.0);
        Payable crypto = new CryptoWallet("0xABC...", 1000.0);

        checkout(card,   150.0);
        checkout(paypal, 300.0);
        checkout(crypto, 500.0);
    }
}
