package lab1;

import java.util.Scanner;

public class PrintMyName {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("My name is Nurik");
            System.out.println("Select task:");
            System.out.println("1 - Square calculator");
            System.out.println("2 - GPA calculator");
            System.out.println("3 - Quadratic equation");
            System.out.println("4 - Saving account");
            System.out.println("5 - Palindrome checker");
            System.out.print("Your choice: ");
            
            int choice = input.nextInt();
            
            switch (choice) {
                case 1 -> {
                    Calc calc = new Calc();
                    System.out.printf("Answer: %.2f%n", calc.start(input));
                }
                case 2 -> {
                    Gpa gpa = new Gpa();
                    System.out.print("Write percent of total points: ");
                    int percent = input.nextInt();
                    gpa.calcGpa(percent);
                }
                case 3 -> {
                    QuadraticRoots roots = new QuadraticRoots();
                    roots.calc(input);
                }
                case 4 -> {
                    SavingAccount account = new SavingAccount();
                    account.balanceAccount();
                }
                case 5 -> {
                    PalindromeChecker checker = new PalindromeChecker();
                    String pal = input.next();
                    checker.check(pal);
                }
                default -> System.out.println("Wrong choice");
            }
        }
    }
}



class Calc{
    public double  start(Scanner input){ 
        System.out.print("Select mod: area, per,lenDi ");
        String mod = input.next();

        System.out.print("Enter first integer: ");
        double  number1 = input.nextInt();
        return switch(mod){
            case "area" -> area(number1); 
            case "per" -> per(number1); 
            case "lenDi" -> lenDi(number1); 
            default -> {
                System.out.print("Wrong mod. Pishi normalno");
                yield 0; 
            }
        };

    }
    double  area(double  a){
        return a * a; 
    } 
    double  per(double  a){
        return 4 * a;
    }
    double lenDi(double  a){
        return a * Math.sqrt(2); 
    } 
}


class Gpa { 
    public void calcGpa(int percent){
        if (percent >= 95 && percent <= 100) {
            System.out.println("Grade: A (Excellent)");
        } else if (percent >= 90) {
            System.out.println("Grade: A- (Excellent)");
        } else if (percent >= 85) {
            System.out.println("Grade: B+ (Good)");
        } else if (percent >= 80) {
            System.out.println("Grade: B (Good)");
        } else if (percent >= 75) {
            System.out.println("Grade: B- (Good)");
        } else if (percent >= 70) {
            System.out.println("Grade: C+ (Satisfactory)");
        } else if (percent >= 65) {
            System.out.println("Grade: C (Satisfactory)");
        } else {
            System.out.println("Grade: F (Unsatisfactory)");
        }

    }
}


class QuadraticRoots {
    public void calc(Scanner scanner) {

        System.out.print("Enter a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("Error: Discriminant is negative. No real roots.");
        } else {
            double sqrtD = Math.sqrt(discriminant);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);

            System.out.println("Root x1 = " + x1);
            System.out.println("Root x2 = " + x2);
        }

    }
}


class SavingAccount {
    public void balanceAccount() {
        double balance = 1000.0;      // initial balance
        double interestRate = 0.05;   // 5%

        double interest = balance * interestRate;
        double newBalance = balance + interest;

        System.out.println("Initial balance: " + balance);
        System.out.println("Interest added: " + interest);
        System.out.println("New balance: " + newBalance);
    }
}


class PalindromeChecker {

    boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void check(String word) {
        

        if (isPalindrome(word)) {
            System.out.println(word + " is a palindrome.");
        } else {
            System.out.println(word + " is not a palindrome.");
        }
    }
}
