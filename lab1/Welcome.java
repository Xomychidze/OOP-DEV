package lab1;

import java.util.Scanner;


        
class Point { 
    int[] metrics; 
    }
interface Move { void move(int dx, int dy); }

public class Welcome {
    public static void main(String[] args) {
        System.out.println("Welcome to Java programming");
        
        Scanner input = new Scanner(System.in);
        Addition obj = new Addition(); 

        obj.func(input);

        
        input.close();

        Point p = new Point(); // p refers to a Point object
        p.metrics = new int[]{1,2,3};

        
    }

}


class Addition{

    public void func(Scanner input){

        int number1;
        int number2;
        int sum; 
        System.out.print("Enter first integer: ");
        number1 = input.nextInt();
        System.out.print("Enter second integer: ");
        number2 = input.nextInt();

        sum = number1 + number2; 
        System.out.printf("Sum is %d\n", sum);

        double annualInterestRate = 0; 
        switch (sum) {
            case 7 -> annualInterestRate = 7.25;
            case 15 -> annualInterestRate = 8.50;
            case 30 -> annualInterestRate = 9.0;
            default -> System.out.println("Wrong number of years, enter 7, 15, or 30");
        }

        System.out.printf("Interest rate: %.2f%%\n ", annualInterestRate);

    }

}
